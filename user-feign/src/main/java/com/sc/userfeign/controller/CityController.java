package com.sc.userfeign.controller;


import com.sc.userfeign.feignService.CityFeignService;
import com.sc.userfeign.pojo.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityController {

    @Autowired
    private CityFeignService cityFeignService;

    @RequestMapping(value = "/findCityById",method = RequestMethod.GET)
    public City findCityById(@RequestParam Long id){
        String s = "feign端访问,";
        City city = cityFeignService.findById(id);
        city.setDescription(s + city.getDescription());
        return city;
    }
}
