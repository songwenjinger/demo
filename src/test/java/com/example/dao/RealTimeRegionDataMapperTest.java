package com.example.dao;

import com.example.entity.RegionData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Iterator;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RealTimeRegionDataMapperTest {
    @Autowired
    RealTimeRegionDataMapper realTimeRegionDataMapper;

    @Test
    public void testQueryRealTimeRegionData() {
        List<RegionData> result = realTimeRegionDataMapper.queryTodayMessage(1);
        Iterator<RegionData> iterator=result.iterator();
        while (iterator.hasNext())
        {
            System.out.println(iterator.next().toString());
        }
    }

}
