package com.horton.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.horton.constant.LcuEnum;
import com.horton.constant.SrcEnum;
import com.horton.constant.TypeEnum;
import com.horton.dto.BdTopDto;
import com.horton.dto.SinaHotDto;
import com.horton.service.AppService;
import com.horton.util.DateTimeUtils;
import com.horton.util.IdWorker;
import lombok.SneakyThrows;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.HashMap;

@RestController
@Component
public class AppController implements Job {

    @Autowired
    private AppService appService;

    @Autowired
    public AppController(AppService appService) {
        this.appService = appService;
    }

    public AppController() {}

    @SneakyThrows
    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        //baidu
        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet("https://top.baidu.com/board?tab=realtime");
        CloseableHttpResponse response = httpClient.execute(httpGet);
        HttpEntity entity = response.getEntity();
        String html = EntityUtils.toString(entity);
        Document document = Jsoup.parse(html);
        Elements titleList = document.select(".c-single-text-ellipsis");
        Elements indexList = document.select(".hot-index_1Bl1a");
        Elements introList = document.select(".large_nSuFU");
        for (int i = 0; i < 31; i++) {
            BdTopDto bdTopDto = new BdTopDto();
            bdTopDto.setId(IdWorker.genId());
            bdTopDto.setSrc(SrcEnum.bd.getSrc());
            bdTopDto.setType(TypeEnum.all.getType());
            bdTopDto.setIdx(Integer.parseInt(indexList.get(i).text()));
            bdTopDto.setTitle(titleList.get(i).text());
            bdTopDto.setIntro(introList.get(i).text());
            bdTopDto.setLcu(LcuEnum.hamster.getLcu());
            try {
                appService.insertBdTop(bdTopDto);
            } catch (Exception e) {
                System.out.println(e.getCause().toString());
            }
        }

        //sina
        DefaultHttpClient httpClient2 = new DefaultHttpClient();
        HttpGet httpGet2 = new HttpGet("https://weibo.com/ajax/side/hotSearch");
        CloseableHttpResponse response2 = httpClient2.execute(httpGet2);
        HttpEntity entity2 = response2.getEntity();
        String string = EntityUtils.toString(entity2);
        JSONObject jsonObject = JSONObject.parseObject(string);
        JSONArray jsonArray = jsonObject.getJSONObject("data").getJSONArray("realtime");
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject object = jsonArray.getJSONObject(i);
            Long onboardTime = object.getLong("onboard_time");
            String word = object.getString("word");
            int boardTime = 0;
            HashMap<String, LocalDateTime> dateHashMap = null;
            if (onboardTime != null) {
                boardTime = Integer.parseInt(DateTimeUtils.stampToBaseDate(onboardTime * 1000));
            }
            if (boardTime != 0) {
                dateHashMap = appService.queryByWord(word);
            }
            if (dateHashMap != null) {
                LocalDateTime date = dateHashMap.get("fcd");
                long epochMilli = date.toInstant(ZoneOffset.ofHours(8)).toEpochMilli();
                String baseDate = DateTimeUtils.stampToBaseDate(epochMilli);
                int fcd = Integer.parseInt(baseDate);
                if (onboardTime < fcd + 1) {
                    continue;
                }
            }

            String mid = object.getString("mid");
            String category = object.getString("category");
            Long rawHot = object.getLong("raw_hot");
            int funWord = object.getIntValue("fun_word");
            String channelType = object.getString("channel_type");
            if (mid == null || mid.isEmpty()) {
                continue;
            }
            SinaHotDto sinaHotDto = new SinaHotDto();
            if (channelType.equals("Entertainment") || funWord == 1) {
                String starName = object.get("star_name").toString();
                if (!starName.isEmpty() && !starName.equals("{}")) {
                    starName = starName.replaceAll("\"", "");
                    starName = starName.substring(1, starName.length() - 1);
                    sinaHotDto.setStarName(starName);
                }
            }
            sinaHotDto.setMid(Long.parseLong(mid));
            sinaHotDto.setCategory(category);
            sinaHotDto.setRowHot(rawHot);
            sinaHotDto.setWord(word);
            sinaHotDto.setFunWord(funWord == 0 ? "N" : "Y");
            sinaHotDto.setChannelType(channelType.equals("Entertainment") ? "1" : "0");
            sinaHotDto.setLcu("Hamster");
            System.out.println(sinaHotDto);
            try {
                appService.insertSinaHot(sinaHotDto);
            } catch (Exception e) {
                System.out.println(e.getCause().toString());
            }
        }
    }
}
