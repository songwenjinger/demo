package com.example.dao;

import com.example.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    User login(@Param("userPhone") String userPhone,
               @Param("password") String password);

    public String getUserPassword(@Param("phone") String phone);

    public int updatePassword(@Param("password") String password, @Param("phone") String phone);
}
