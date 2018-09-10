package com.sc.eurekauserclient.service;

import com.sc.eurekauserclient.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserService {
    User findByName(@Param("name") String name);
}
