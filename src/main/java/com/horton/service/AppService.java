package com.horton.service;

import com.horton.VO.Item;
import com.horton.dao.AppMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppService {

    @Autowired
    private AppMapper appMapper;

    public void insertItem(Item item) {
        appMapper.insertItem(item);
    }


    public void saveLog() {
        appMapper.saveLog();
    }
}
