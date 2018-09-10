package com.sc.userfeign.feignService;


import com.sc.userfeign.hystrixFallback.FeignServiceFallback;
import com.sc.userfeign.pojo.City;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "SERVICE-USER",fallback = FeignServiceFallback.class)
public interface CityFeignService {

    @RequestMapping(value = "getCityById",method = RequestMethod.GET)
    City findById(@RequestParam("id") Long id);
}
