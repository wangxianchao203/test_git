package com.sc.eurekauserclient.dao;


import com.sc.eurekauserclient.pojo.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


/**
 * 城市 DAO 接口类
 */
@Mapper
public interface CityDao {

    City findById(@Param("id") Long id);
}
