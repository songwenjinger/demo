package com.example.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ author: SongWenjing
 * @ Date 2020/5/9 12:33
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class userServiceTest {
    @Autowired
    UserService userService;

    @Test
    public void updatePassWord() {
        System.out.println(userService.updatePassword("abcd", "1111", "13201656250"));
    }
}
