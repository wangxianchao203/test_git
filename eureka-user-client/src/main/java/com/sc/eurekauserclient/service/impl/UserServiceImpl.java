package com.sc.eurekauserclient.service.impl;

import com.sc.eurekauserclient.dao.UserDao;
import com.sc.eurekauserclient.pojo.User;
import com.sc.eurekauserclient.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User findByName(String name){
        return userDao.findByName(name);
    }
}
