package com.horton.controller;

import com.horton.VO.Item;
import com.horton.constant.LcuBase;
import com.horton.constant.TypeBase;
import com.horton.service.AppService;
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
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

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
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
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
            Item item = new Item();
            item.setId(IdWorker.genId());
            item.setType(TypeBase.all.getType());
            item.setIdx(Integer.parseInt(indexList.get(i).text()));
            item.setTitle(titleList.get(i).text());
            item.setIntro(introList.get(i).text());
            item.setLcu(LcuBase.hamster.getUser());
            try {
                appService.insertItem(item);
            } catch (Exception e) {
                if (e.getMessage().contains("SQLIntegrityConstraintViolationException")) {
                    appService.saveLog();
                } else {
                    e.printStackTrace();
                }
            }
        }
    }
}
