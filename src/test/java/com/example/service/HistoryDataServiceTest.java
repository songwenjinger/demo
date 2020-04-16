package com.example.service;

import com.example.dao.HistoryDataMapper;
import com.example.entity.PropertyDataStatistics;
import com.example.response.ServerResponse;
import org.apache.catalina.Server;
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
 * @author: SongWenjing
 * @Date 2020/4/16 10:55
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class HistoryDataServiceTest {
    @Autowired
    HistoryDataService historyDataService;

    @Test
    public void testQueryByUserDefined() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date startTime = sdf.parse("2019-04-10");
        Date endTime = sdf.parse("2020-04-06");
        ServerResponse serverResponse = historyDataService.queryByUserDefined(1, startTime, endTime);
        System.out.println(serverResponse);
    }

    @Test
    public void testQueryByWeek() {
        ServerResponse serverResponse = historyDataService.queryByWeek(1, 2);
        System.out.println(serverResponse);
    }

    @Test
    public void testQueryByMonth() {
        ServerResponse serverResponse = historyDataService.queryByMonth(1, 2);
        System.out.println(serverResponse);
    }

    @Test
    public void testQueryByYear() {
        ServerResponse serverResponse = historyDataService.queryByYear(1, 4);
        System.out.println(serverResponse);
    }
}
