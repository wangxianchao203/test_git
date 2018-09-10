package com.sc.eurekauserclient.controller;

import com.sc.eurekauserclient.pojo.City;
import com.sc.eurekauserclient.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableEurekaClient
public class CityController {

    @Value("${server.port}")
    String port;
    @Value("${spring.application.name}")
    String serviceName;
    @Autowired
    private CityService cityService;

    @RequestMapping("getCityById")
    public City getCityById (@RequestParam Long id){

        String desc = ",通过client:服务和端口  "+port+":"+serviceName+"获得";
        City city = cityService.findById(id);
        city.setDescription(city.getDescription()+desc);
        return city;
    }
}
