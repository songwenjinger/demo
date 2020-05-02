package com.example.dao;

import com.example.entity.RegionData;
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

    @Test
    public void testQueryByCondition() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date startTime = sdf.parse("2019-04-10");
        Date endTime = sdf.parse("2020-04-29");
        List<RegionData> list = detailedDataQueryMapper.queryByCondition(1, startTime, endTime);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }
    }

    @Test
    public void testQueryByConditionOrderBySendTimeAsc() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date startTime = sdf.parse("2019-04-10");
        Date endTime = sdf.parse("2020-04-29");
        List<RegionData> list = detailedDataQueryMapper.queryByConditionOrderBySendTimeAsc(1, startTime, endTime);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }
    }

    @Test
    public void testQueryByConditionOrderBySendTimeDesc() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date startTime = sdf.parse("2019-04-10");
        Date endTime = sdf.parse("2020-04-29");
        List<RegionData> list = detailedDataQueryMapper.queryByConditionOrderBySendTimeDesc(1, startTime, endTime);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }
    }

    @Test
    public void testQueryByConditionOrderByZoneIdAsc() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date startTime = sdf.parse("2019-04-10");
        Date endTime = sdf.parse("2020-04-29");
        List<RegionData> list = detailedDataQueryMapper.queryByConditionOrderByZoneIdAsc(1, startTime, endTime);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }
    }

    @Test
    public void testQueryByConditionOrderByZoneIdDesc() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date startTime = sdf.parse("2019-04-10");
        Date endTime = sdf.parse("2020-04-29");
        List<RegionData> list = detailedDataQueryMapper.queryByConditionOrderByZoneIdDesc(1, startTime, endTime);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }
    }
}
