package com.example.dao;

import com.example.auxiliary.DataStatistics;
import com.example.entity.RegionData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.jws.Oneway;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RealTimeRegionDataMapperTest {
    @Autowired
    RealTimeRegionDataMapper realTimeRegionDataMapper;

    @Test
    public void testQueryRealTimeRegionData() {
        List<RegionData> result = realTimeRegionDataMapper.queryTodayMessage(1);
        Iterator<RegionData> iterator = result.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }
    }

    @Test
    public void testQueryPaginationTodayMessage() {
        List<RegionData> result = realTimeRegionDataMapper.queryPaginationTodayMessage(1, 2, 6);
        Iterator<RegionData> iterator = result.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }
    }

    @Test
    public void testQueryPaginationTodayMessageDescend() {
        List<RegionData> result = realTimeRegionDataMapper.queryPaginationTodayMessageDescend(1, 2, 6);
        Iterator<RegionData> iterator = result.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }
    }

    @Test
    public void testDataStatistics() {
        DataStatistics result = realTimeRegionDataMapper.dataStatistics(1,"ph");
//        Iterator iterator = result.iterator();
//        System.out.println(result.size());
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }
        System.out.println(result);
    }
}
