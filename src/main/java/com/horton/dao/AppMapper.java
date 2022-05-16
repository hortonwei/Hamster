package com.horton.dao;

import com.horton.dto.BdTopDto;
import com.horton.dto.SinaHotDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AppMapper{

    void insertBdTop(BdTopDto bdTopDto);

    void insertSinaHot(SinaHotDto sinaHotDto);


}
