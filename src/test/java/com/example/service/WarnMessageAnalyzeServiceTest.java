package com.example.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.util.*;

/**
 * @ author: SongWenjing
 * @ Date 2020/5/3 18:59
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class WarnMessageAnalyzeServiceTest {
    @Autowired
    WarnMessageAnalyzeService warnMessageAnalyzeService;

    @Test
    public void testZoneCompare() throws ParseException {
        LinkedHashMap<Object, Object> linkedHashMap = warnMessageAnalyzeService.zoneCompare("2019-04-10", "2020-04-06");
        Iterator it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            System.out.println("key:" + entry.getKey() + "   value:" + entry.getValue());
        }

    }

    @Test
    public void testReasonCompare() throws ParseException {
        LinkedHashMap<Object, ArrayList<Object>> linkedHashMap = warnMessageAnalyzeService.reasonCompare(1, "2019-04-10", "2020-04-06");
        Iterator iterator = linkedHashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Object, ArrayList<Object>> entry = (Map.Entry) iterator.next();
            ArrayList<Object> arrayList = entry.getValue();
            Iterator iterator1 = arrayList.iterator();
            while (iterator1.hasNext()) {
                System.out.println("key:" + entry.getKey() + " " + iterator1.next());
            }
        }
    }

}
