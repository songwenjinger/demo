package com.example.dao;

import com.example.entity.PropertyDataStatistics;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Iterator;
import java.util.List;

/**
 * @ author: SongWenjing
 * @ Date 2020/4/30 17:33
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StatisticsDataMapperTest {
    @Autowired
    StatisticsDataQueryMapper statisticsDataQueryMapper;

    @Test
    public void testQueryAll() {
        List<PropertyDataStatistics> list = statisticsDataQueryMapper.queryAll();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }
    }

}
