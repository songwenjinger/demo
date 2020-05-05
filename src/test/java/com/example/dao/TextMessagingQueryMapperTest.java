package com.example.dao;

import com.example.entity.TextMessaging;
import com.example.entity.WarnMessage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * @ author: SongWenjing
 * @ Date 2020/5/4 16:31
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TextMessagingQueryMapperTest {
    @Autowired
    TextMessagingQueryMapper textMessagingQueryMapper;

    @Test
    public void testQueryAll() {
        List<TextMessaging> list = textMessagingQueryMapper.queryAll();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void testQueryByCondition() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date startTime = sdf.parse("2019-04-10");
        Date endTime = sdf.parse("2020-04-06");
        List<TextMessaging> list = textMessagingQueryMapper.queryByCondition(1, startTime, endTime);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }
    }

}
