package com.example.service;

import com.example.entity.User;

public interface UserService {

    public User login(String uerName, String pwd);

    public String getUserPassword(String phone);

    public int updatePassword(String originPassword, String password, String phone);
}
