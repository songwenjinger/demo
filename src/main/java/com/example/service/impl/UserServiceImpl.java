package com.example.service.impl;

import com.example.dao.UserMapper;
import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;


    @Override
    public User login(String userPhone, String pwd) {
        return userMapper.login(userPhone, pwd);
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public String getUserPassword(String phone) {
        return userMapper.getUserPassword(phone);
    }

    @Override
    public int updatePassword(String originPassword, String password, String phone) {
        String correctPassword = getUserPassword(phone);
        if (!originPassword.equals(correctPassword)) {
            return -1;
        } else {
            return userMapper.updatePassword(password, phone);
        }
    }
}
