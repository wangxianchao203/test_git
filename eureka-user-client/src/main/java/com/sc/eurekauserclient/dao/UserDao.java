package com.sc.eurekauserclient.dao;


import com.sc.eurekauserclient.pojo.City;
import com.sc.eurekauserclient.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserDao {

    User findByName(@Param("name") String name);
}
