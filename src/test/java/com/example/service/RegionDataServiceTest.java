package com.example.service;

import com.example.entity.RegionData;
import com.example.response.ServerResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RegionDataServiceTest {
    @Autowired
    private RegionDataService regionDataService;

    @Test
    public void queryRealTimeRegionData() {
        ServerResponse serverResponse = regionDataService.queryRealTimeRegionData(1);
        System.out.println(serverResponse.toString());
    }
}
