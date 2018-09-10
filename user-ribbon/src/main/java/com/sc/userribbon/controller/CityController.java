package com.sc.userribbon.controller;


import com.sc.userribbon.pojo.City;
import com.sc.userribbon.service.CityRibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityController {

    @Autowired
    private CityRibbonService cityFeignService;

    @RequestMapping(value = "/findCityById",method = RequestMethod.GET)
    public City findCityById(@RequestParam Long id){
        String s = "ribbon端访问,";
        City city = cityFeignService.findById(id);
        city.setDescription(s + city.getDescription());
        return city;
    }
}
