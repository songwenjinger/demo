package com.example.service.impl;

import com.example.dao.WarnMessageAnalyzeMapper;
import com.example.service.WarnMessageAnalyzeService;
import com.example.util.DateParse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @ author: SongWenjing
 * @ Date 2020/5/3 18:48
 */
@Service
public class WarnMessageAnalyzeServiceImpl implements WarnMessageAnalyzeService {
    @Autowired
    WarnMessageAnalyzeMapper warnMessageAnalyzeMapper;

    @Override
    public LinkedHashMap<Object, Object> zoneCompare(String startTime, String endTime) throws ParseException {
        LinkedHashMap<Object, Object> result = new LinkedHashMap<>();
        List<LinkedHashMap<Object, Object>> linkedHashMap = warnMessageAnalyzeMapper.zoneCompare(DateParse.parseDate(startTime),
                DateParse.parseDate(endTime));
        if (linkedHashMap != null && !linkedHashMap.isEmpty()) {
            for (LinkedHashMap<Object, Object> map1 : linkedHashMap) {
                Object key = null;
                Object value = null;
                for (Map.Entry<Object, Object> entry : map1.entrySet()) {
                    if ("key".equals(entry.getKey())) {
                        key = entry.getValue();
                    } else if ("value".equals(entry.getKey())) {
                        value = entry.getValue();
                    }
                }
                result.put(key, value);
            }
        }
        return result;
    }

    @Override
    public LinkedHashMap<Object, ArrayList<Object>> reasonCompare(Integer zoneId, String startTime, String endTime) throws ParseException {
        LinkedHashMap<Object, ArrayList<Object>> result = new LinkedHashMap<>();
        List<LinkedHashMap<Object, Object>> linkedHashMap = warnMessageAnalyzeMapper.reasonCompare(zoneId,
                DateParse.parseDate(startTime),
                DateParse.parseDate(endTime));
        if (linkedHashMap != null && !linkedHashMap.isEmpty()) {
            for (LinkedHashMap<Object, Object> map1 : linkedHashMap) {
                Object messageCode = null;
                Object message = null;
                Object count = null;
                ArrayList<Object> arrayList = new ArrayList<Object>();
                for (Map.Entry<Object, Object> entry : map1.entrySet()) {
                    if ("messageCode".equals(entry.getKey())) {
                        messageCode = entry.getValue();
                    } else if ("message".equals(entry.getKey())) {
                        message = entry.getValue();
                        arrayList.add(message);
                    } else if ("count".equals(entry.getKey())) {
                        count = entry.getValue();
                        arrayList.add(count);
                    }
                }
                result.put(messageCode, arrayList);
            }
        }
        return result;
    }
}
