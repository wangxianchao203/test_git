package com.sc.userribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sc.userribbon.pojo.City;
import com.sc.userribbon.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Service
public class UserRibbonService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "error")
    public User findByName(@RequestParam("name") String name){
        return restTemplate.getForObject("http://SERVICE-USER/getUserByName?name="+name,User.class);
    }

    public User error(String name){
        User user = new User();
        String desc = "sorry,访问 SERVICE-USER服务 出错, 根据name获取user失败， name="+name;
        user.setDesc(desc);
        return user;
    }
}
