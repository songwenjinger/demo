package com.example.service.impl;

import com.example.entity.PropertyDataStatistics;
import com.example.dao.HistoryDataMapper;
import com.example.response.ServerResponse;
import com.example.service.HistoryDataService;
import com.example.util.DateParse;
import com.example.util.TransformIntArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author: SongWenjing
 * @Date 2020/4/16 10:39
 */
@Service
public class HistoryDataServiceImpl implements HistoryDataService {
    @Autowired
    HistoryDataMapper historyDataMapper;

    @Override
    public ServerResponse queryByUserDefined(Integer zoneId, String startTime, String endTime) throws ParseException {
        Date startDate = DateParse.parseDate(startTime);
        Date endDate = DateParse.parseDate(endTime);
        List<PropertyDataStatistics> list = historyDataMapper.queryByUserDefined(zoneId, startDate, endDate);
        if (list == null) {
            return ServerResponse.createByErrorMessage("查不到数据");
        } else {
            return ServerResponse.createBySuccess(list);
        }
    }

    @Override
    public ServerResponse queryByWeek(Integer zoneId, Integer num) {
        List<PropertyDataStatistics> list = historyDataMapper.queryByWeek(zoneId, num);
        if (list == null) {
            return ServerResponse.createByErrorMessage("查不到数据");
        } else {
            return ServerResponse.createBySuccess(list);
        }
    }

    @Override
    public ServerResponse queryByMonth(Integer zoneId, Integer num) {
        List<PropertyDataStatistics> list = historyDataMapper.queryByMonth(zoneId, num);
        if (list == null) {
            return ServerResponse.createByErrorMessage("查不到数据");
        } else {
            return ServerResponse.createBySuccess(list);
        }
    }

    @Override
    public ServerResponse queryByYear(Integer zoneId, Integer num) {
        List<PropertyDataStatistics> list = historyDataMapper.queryByYear(zoneId, num);
        if (list == null) {
            return ServerResponse.createByErrorMessage("查不到数据");
        } else {
            return ServerResponse.createBySuccess(list);
        }
    }

    @Override
    public ServerResponse queryRecentSevenDays(Integer zoneId) {
        List<PropertyDataStatistics> list = historyDataMapper.queryRecentSevenDays(zoneId);
        if (list == null) {
            return ServerResponse.createByErrorMessage("查不到数据");
        } else {
            return ServerResponse.createBySuccess(list);
        }
    }

    @Override
    public ServerResponse queryMultiByUserDefined(String zoneMessage, String startTime, String endTime) throws ParseException {
        LinkedHashMap<Integer, List<PropertyDataStatistics>> linkedHashMap = new LinkedHashMap<Integer, List<PropertyDataStatistics>>();
        Date startDate = DateParse.parseDate(startTime);
        Date endDate = DateParse.parseDate(endTime);
        int[] zoneMessageIntArray = TransformIntArray.transformIntArray(zoneMessage);
        for (int i = 0; i < zoneMessageIntArray.length; i++) {
            linkedHashMap.put(zoneMessageIntArray[i], historyDataMapper.queryByUserDefined(zoneMessageIntArray[i], startDate, endDate));
        }
        if (linkedHashMap.isEmpty()) {
            return ServerResponse.createByErrorMessage("查不到数据");
        } else {
            return ServerResponse.createBySuccess(linkedHashMap);
        }
    }

    @Override
    public ServerResponse queryMultiByWeek(String zoneMessage, Integer num) {
        LinkedHashMap<Integer, List<PropertyDataStatistics>> linkedHashMap = new LinkedHashMap<Integer, List<PropertyDataStatistics>>();
        int[] zoneMessageIntArray = TransformIntArray.transformIntArray(zoneMessage);
        for (int i = 0; i < zoneMessageIntArray.length; i++) {
            linkedHashMap.put(zoneMessageIntArray[i], historyDataMapper.queryByWeek(zoneMessageIntArray[i], num));
        }
        if (linkedHashMap.isEmpty()) {
            return ServerResponse.createByErrorMessage("查不到数据");
        } else {
            return ServerResponse.createBySuccess(linkedHashMap);
        }
    }

    @Override
    public ServerResponse queryMultiByMonth(String zoneMessage, Integer num) {
        LinkedHashMap<Integer, List<PropertyDataStatistics>> linkedHashMap = new LinkedHashMap<Integer, List<PropertyDataStatistics>>();
        int[] zoneMessageIntArray = TransformIntArray.transformIntArray(zoneMessage);
        for (int i = 0; i < zoneMessageIntArray.length; i++) {
            linkedHashMap.put(zoneMessageIntArray[i], historyDataMapper.queryByMonth(zoneMessageIntArray[i], num));
        }
        if (linkedHashMap.isEmpty()) {
            return ServerResponse.createByErrorMessage("查不到数据");
        } else {
            return ServerResponse.createBySuccess(linkedHashMap);
        }
    }

    @Override
    public ServerResponse queryMultiByYear(String zoneMessage, Integer num) {
        LinkedHashMap<Integer, List<PropertyDataStatistics>> linkedHashMap = new LinkedHashMap<Integer, List<PropertyDataStatistics>>();
        int[] zoneMessageIntArray = TransformIntArray.transformIntArray(zoneMessage);
        for (int i = 0; i < zoneMessageIntArray.length; i++) {
            linkedHashMap.put(zoneMessageIntArray[i], historyDataMapper.queryByYear(zoneMessageIntArray[i], num));
        }
        if (linkedHashMap.isEmpty()) {
            return ServerResponse.createByErrorMessage("查不到数据");
        } else {
            return ServerResponse.createBySuccess(linkedHashMap);
        }
    }

    @Override
    public ServerResponse queryMultiRecentSevenDays(String zoneMessage) {
        LinkedHashMap<Integer, List<PropertyDataStatistics>> linkedHashMap = new LinkedHashMap<Integer, List<PropertyDataStatistics>>();
        int[] zoneMessageIntArray = TransformIntArray.transformIntArray(zoneMessage);
        for (int i = 0; i < zoneMessageIntArray.length; i++) {
            linkedHashMap.put(zoneMessageIntArray[i], historyDataMapper.queryRecentSevenDays(zoneMessageIntArray[i]));
        }
        if (linkedHashMap.isEmpty()) {
            return ServerResponse.createByErrorMessage("查不到数据");
        } else {
            return ServerResponse.createBySuccess(linkedHashMap);
        }
    }
}
