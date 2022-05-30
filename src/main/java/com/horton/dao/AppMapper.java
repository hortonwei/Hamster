package com.horton.dao;

import com.horton.dto.BdTopDto;
import com.horton.dto.SinaHotDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;

@Mapper
@Repository
public interface AppMapper{

    void insertBdTop(BdTopDto bdTopDto);

    void insertSinaHot(SinaHotDto sinaHotDto);

    HashMap<String, LocalDateTime> queryByWord(@Param("word")String word);
}
