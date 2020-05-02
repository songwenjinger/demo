package com.example.dao;

import com.example.entity.PropertyDataStatistics;
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

    @Test
    public void testQueryByWeek() {
        List<PropertyDataStatistics> dataStatistics = statisticsDataQueryMapper.queryByWeek(1, 2);
        System.out.println("size:" + dataStatistics.size());
        Iterator iterator = dataStatistics.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }

    @Test
    public void testQueryByMonth() {
        List<PropertyDataStatistics> dataStatistics = statisticsDataQueryMapper.queryByMonth(1, 2);
        System.out.println("size:" + dataStatistics.size());
        Iterator iterator = dataStatistics.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void testQueryByYear() {
        List<PropertyDataStatistics> dataStatistics = statisticsDataQueryMapper.queryByYear(1, 4);
        System.out.println("size:" + dataStatistics.size());
        Iterator iterator = dataStatistics.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void testQueryByUserDefined() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date startTime = sdf.parse("2019-04-10");
        Date endTime = sdf.parse("2020-04-06");
        List<PropertyDataStatistics> dataStatisticsList = statisticsDataQueryMapper.queryByUserDefined(1, startTime, endTime);
        System.out.println("size:" + dataStatisticsList.size());
        Iterator iterator = dataStatisticsList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
