package com.sc.eurekauserclient.service.impl;

import com.sc.eurekauserclient.dao.CityDao;
import com.sc.eurekauserclient.pojo.City;
import com.sc.eurekauserclient.service.CityService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService{

    @Autowired
    private CityDao cityDao;

    @Override
    public City findById(Long id){
        return cityDao.findById(id);
    }
}
