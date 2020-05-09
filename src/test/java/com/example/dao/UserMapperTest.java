package com.example.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ author: SongWenjing
 * @ Date 2020/5/8 21:19
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
    @Autowired
    UserMapper userMapper;

    @Test
    public void testUpdatePassword() {
        int result = userMapper.updatePassword("abcd", "13201656250");
        System.out.println(result);
    }

    @Test
    public void getPassword() {
        String result = userMapper.getUserPassword("13201656250");
        System.out.println(result);
    }

}
