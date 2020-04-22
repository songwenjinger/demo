package com.example.service;

/**
 * @author: SongWenjing
 * @Date 2020/4/22 10:11
 */

import com.example.response.ServerResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HistoryDataCompareTest {
    @Autowired
    HistoryDataService historyDataService;

    @Test
    public void testQueryMultiByUserDefined() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date startTime = sdf.parse("2019-04-10");
        Date endTime = sdf.parse("2020-04-06");
        ServerResponse serverResponse = historyDataService.queryMultiByUserDefined("1,2", "2019-04-10", "2020-04-06");
        System.out.println(serverResponse);
    }

    @Test
    public void testQueryMultiByWeek() {
        ServerResponse serverResponse = historyDataService.queryMultiByWeek("1,2", 2);
        System.out.println(serverResponse);
    }

    @Test
    public void testQueryMultiByMonth() {
        ServerResponse serverResponse = historyDataService.queryMultiByMonth("1,2", 2);
        System.out.println(serverResponse);
    }

    @Test
    public void testQueryMultiByYear() {
        ServerResponse serverResponse = historyDataService.queryMultiByYear("1,2", 4);
        System.out.println(serverResponse);
    }

    @Test
    public void queryMultiRecentSevenDays() {
        ServerResponse serverResponse = historyDataService.queryMultiRecentSevenDays("1,2");
        System.out.println(serverResponse);
    }

}
