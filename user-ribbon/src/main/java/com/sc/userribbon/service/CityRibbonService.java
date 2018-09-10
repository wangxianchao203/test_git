package com.sc.userribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sc.userribbon.pojo.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Service
public class CityRibbonService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "error")
    public City findById(@RequestParam("id") Long id){
        return restTemplate.getForObject("http://SERVICE-USER/getCityById?id="+id,City.class);
    }

    public City error(Long id){
        City city = new City();
        String desc = "sorry,访问 SERVICE-USER服务 出错, 根据id获取city失败， city_id="+id;
        city.setDescription(desc);
        return city;
    }
}
