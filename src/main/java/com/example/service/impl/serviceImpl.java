package com.example.service.impl;

import com.example.dao.UserMapper;
import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class serviceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;


    @Override
    public User login(String uName, String pwd) {
        return userMapper.login(uName,pwd);
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
}
