package com.example.dao;

import com.example.entity.RegionData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Iterator;
import java.util.List;

/**
 * @ author: SongWenjing
 * @ Date 2020/4/23 9:42
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DetailedDataQueryMapperMapperTest {
    @Autowired
    DetailedDataQueryMapper detailedDataQueryMapper;

    @Test
    public void testQueryAll() {
        List<RegionData> list = detailedDataQueryMapper.queryAll();
        Iterator<RegionData> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
