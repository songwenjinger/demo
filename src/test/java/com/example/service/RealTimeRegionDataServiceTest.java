package com.example.service;

import com.example.response.ServerResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RealTimeRegionDataServiceTest {

    @Autowired
    private RealTimeRegionDataService realTimeRegionDataService;

    @Test
    public void queryRealTimeRegionData() {
        ServerResponse serverResponse = realTimeRegionDataService.queryTodayMessage(1);
        System.out.println(serverResponse.toString());
    }

    @Test
    public void testQueryDataStatistics() {
        ServerResponse serverResponse=realTimeRegionDataService.dataStatistics(1);
        System.out.println(serverResponse.toString());
    }
}

