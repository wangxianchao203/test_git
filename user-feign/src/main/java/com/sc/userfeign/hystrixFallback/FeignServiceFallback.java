package com.sc.userfeign.hystrixFallback;


import com.sc.userfeign.feignService.CityFeignService;
import com.sc.userfeign.feignService.UserFeignService;
import com.sc.userfeign.pojo.City;
import com.sc.userfeign.pojo.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class FeignServiceFallback implements CityFeignService,UserFeignService {

    @Override
    public City findById(Long id){
        City city = new City();
        String desc = "sorry,访问 SERVICE-USER服务 出错, 根据id获取city失败， city_id="+id;
        city.setDescription(desc);
        return city;
    }

    @Override
    public User findByName(String name){
        User user = new User();
        String desc = "sorry,访问 SERVICE-USER服务 出错, 根据name获取user失败， name="+name;
        user.setDesc(desc);
        return user;
    }
}
