package com.example.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @ author: SongWenjing
 * @ Date 2020/5/3 12:01
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class WarnMessageAnalyzeMapperTest {
    @Autowired
    WarnMessageAnalyzeMapper warnMessageAnalyzeMapper;

    @Test
    public void testZoneCompare() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date startTime = sdf.parse("2019-04-10");
        Date endTime = sdf.parse("2020-04-06");
        List<LinkedHashMap<Object, Object>> linkedHashMap = warnMessageAnalyzeMapper.zoneCompare(startTime, endTime);
        if (linkedHashMap != null && !linkedHashMap.isEmpty()) {
            for (LinkedHashMap<Object, Object> map1 : linkedHashMap) {
                Object key = null;
                Object value = null;
                for (Map.Entry<Object, Object> entry : map1.entrySet()) {
                    if ("key".equals(entry.getKey())) {
                        key = entry.getValue();
                        //代码重复不好看，暂时加着一句，Test不影响
                        System.out.println();
                    } else if ("value".equals(entry.getKey())) {
                        value = entry.getValue();
                    }
                }
                System.out.println(key + "->" + value);
            }
        }
    }

    @Test
    public void testReasonCompare() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date startTime = sdf.parse("2019-04-10");
        Date endTime = sdf.parse("2020-04-06");
        List<LinkedHashMap<Object, Object>> linkedHashMap = warnMessageAnalyzeMapper.reasonCompare(1, startTime, endTime);
        if (linkedHashMap != null && !linkedHashMap.isEmpty()) {
            for (LinkedHashMap<Object, Object> map1 : linkedHashMap) {
                Object messageCode = null;
                Object message = null;
                Object count = null;
                for (Map.Entry<Object, Object> entry : map1.entrySet()) {
                    if ("messageCode".equals(entry.getKey())) {
                        messageCode = entry.getValue();
                    } else if ("message".equals(entry.getKey())) {
                        message = entry.getValue();
                    } else {
                        count = entry.getValue();
                    }
                }
                System.out.println(messageCode + "->" + message + "->" + count);
            }
        }
    }
}
