package com.sc.userfeign.controller;

import com.sc.userfeign.feignService.CityFeignService;
import com.sc.userfeign.feignService.UserFeignService;
import com.sc.userfeign.pojo.City;
import com.sc.userfeign.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserFeignService userFeignService;
    @Autowired
    private CityFeignService cityFeignService;

    @RequestMapping(value = "/findUserByName",method = RequestMethod.GET)
    public User findUserByName(@RequestParam String name){
        User user = userFeignService.findByName(name);
        if (user.getId()==null){
            return user;
        }
        String desc = "通过feign访问SERVICE-USER服务找到user";
        City city = cityFeignService.findById(Long.valueOf(user.getCityId()));
        user.setCity(city);
        return user;
    }
}
