package com.sc.userfeign.feignService;

import com.sc.userfeign.hystrixFallback.FeignServiceFallback;
import com.sc.userfeign.pojo.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "SERVICE-USER",fallback = FeignServiceFallback.class)
public interface UserFeignService {

    @RequestMapping(value = "getUserByName",method = RequestMethod.GET)
    User findByName(@RequestParam("name") String name);
}
