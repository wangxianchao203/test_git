package com.sc.eurekauserclient.service;

import com.sc.eurekauserclient.pojo.City;
import org.apache.ibatis.annotations.Param;

public interface CityService {

    City findById(@Param("id") Long id);
}
