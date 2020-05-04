package com.example.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * @ author: SongWenjing
 * @ Date 2020/5/3 18:47
 */
public interface WarnMessageAnalyzeService {
    public LinkedHashMap<Object, Object> zoneCompare(String startTime, String endTime) throws ParseException;

    public LinkedHashMap<Object, ArrayList<Object>> reasonCompare(Integer zoneId, String startTime, String endTime) throws ParseException;
}
