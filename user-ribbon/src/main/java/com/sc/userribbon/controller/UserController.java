package com.sc.userribbon.controller;


import com.sc.userribbon.pojo.City;
import com.sc.userribbon.pojo.User;
import com.sc.userribbon.service.CityRibbonService;
import com.sc.userribbon.service.UserRibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRibbonService userRibbonService;
    @Autowired
    private CityRibbonService cityRibbonService;

    @RequestMapping(value = "/findUserByName",method = RequestMethod.GET)
    public User findUserByName(@RequestParam String name){
        String s = "ribbon端访问,";
        User user = userRibbonService.findByName(name);
        if (user.getId()==null){
            return user;
        }
        String desc = "通过feign访问SERVICE-USER服务找到user";
        City city = cityRibbonService.findById(Long.valueOf(user.getCityId()));
        user.setCity(city);
        return user;
    }
}
