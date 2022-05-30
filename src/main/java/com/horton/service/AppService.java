package com.horton.service;

import com.horton.dto.BdTopDto;
import com.horton.dao.AppMapper;
import com.horton.dto.SinaHotDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;

@Service
public class AppService {

    @Autowired
    private AppMapper appMapper;

    public void insertBdTop(BdTopDto bdTopDto) {
        appMapper.insertBdTop(bdTopDto);
    }

    public void insertSinaHot(SinaHotDto sinaHotDto) {
        appMapper.insertSinaHot(sinaHotDto);
    }

    public HashMap<String, LocalDateTime> queryByWord(String word) {
        return appMapper.queryByWord(word);
    }
}
