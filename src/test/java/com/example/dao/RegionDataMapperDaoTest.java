package com.example.dao;

import com.example.entity.RegionData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RegionDataMapperDaoTest {
    @Autowired
    RegionDataMapper regionData;

    @Test
    public void testQueryRealTimeRegionData() {
        RegionData result = regionData.queryRealTimeRegionData(1);
        System.out.println(result.toString());
    }

}
