package com.horton.dao;

import com.horton.VO.Item;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AppMapper{

    void insertItem(Item item);

    void saveLog();
}
