package com.example.service.impl;

import com.example.auxiliary.DataStatistics;
import com.example.dao.RealTimeRegionDataMapper;
import com.example.entity.RegionData;
import com.example.response.ServerResponse;
import com.example.service.RealTimeRegionDataService;
import com.example.util.TransformIntArray;
import org.apache.catalina.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

@Service
public class RealTimeRegionDataServiceImpl implements RealTimeRegionDataService {
    String[] property = {"water_temperature", "ph", "cod", "nh3",
            "dox", "conductivity", "turbidity"};
    @Autowired
    RealTimeRegionDataMapper realTimeRegionDataMapper;

    @Override
    public ServerResponse queryTodayMessage(Integer id) {
        List<RegionData> result = realTimeRegionDataMapper.queryTodayMessage(id);
        if (result == null) {
            return ServerResponse.createByErrorMessage("查不到数据");
        } else {
            return ServerResponse.createBySuccess(result);
        }
    }

    @Override
    public ServerResponse queryPaginationTodayMessage(Integer zoneId, Integer startNum, Integer limitNum) {
        List<RegionData> result = realTimeRegionDataMapper.queryPaginationTodayMessage(zoneId, startNum, limitNum);
        if (result == null) {
            return ServerResponse.createByErrorMessage("查不到数据");
        } else {
            return ServerResponse.createBySuccess(result);
        }
    }

    @Override
    public ServerResponse queryPaginationTodayMessageDescend(Integer zoneId, Integer startNum, Integer limitNum) {
        List<RegionData> result = realTimeRegionDataMapper.queryPaginationTodayMessageDescend(zoneId, startNum, limitNum);
        if (result == null) {
            return ServerResponse.createByErrorMessage("查不到数据");
        } else {
            return ServerResponse.createBySuccess(result);
        }
    }

    @Override
    public ServerResponse dataStatistics(Integer zoneId) {
        LinkedHashMap<String, DataStatistics> dataStatisticsLinkedHashMap = new LinkedHashMap<String, DataStatistics>();
        for (int i = 0; i < property.length; i++) {
            dataStatisticsLinkedHashMap.put(property[i], realTimeRegionDataMapper.dataStatistics(zoneId, property[i]));
        }
        if (dataStatisticsLinkedHashMap.isEmpty()) {
            return ServerResponse.createByErrorMessage("查不到数据");
        } else {
            return ServerResponse.createBySuccess(dataStatisticsLinkedHashMap);
        }
    }

    /**
     * 区域信息实时处理_根据传进来的string字符串，截取出需要对比的区域
     *
     * @param zoneMessage controller层传来的字符串
     * @return ServerResponse
     */
    @Override
    public ServerResponse queryMultiTodayMessage(String zoneMessage) {
        LinkedHashMap<Integer, List<RegionData>> linkedHashMap = new LinkedHashMap<Integer, List<RegionData>>();
        int[] zoneMessageIntArray = TransformIntArray.transformIntArray(zoneMessage);
        for (int i = 0; i < zoneMessageIntArray.length; i++) {
            linkedHashMap.put(zoneMessageIntArray[i], realTimeRegionDataMapper.queryTodayMessage(zoneMessageIntArray[i]));
        }
        if (linkedHashMap.isEmpty()) {
            return ServerResponse.createByErrorMessage("查不到数据");
        } else {
            return ServerResponse.createBySuccess(linkedHashMap);
        }
    }

    @Override
    public ServerResponse queryMultiDataStatistics(String zoneMessage) {
        LinkedHashMap<Integer, HashMap<String, DataStatistics>> linkedHashMap = new LinkedHashMap<Integer, HashMap<String, DataStatistics>>();
        int[] zoneMessageIntArray = TransformIntArray.transformIntArray(zoneMessage);
        for (int i = 0; i < zoneMessageIntArray.length; i++) {
            LinkedHashMap<String, DataStatistics> propertyDataStatistic = new LinkedHashMap<String, DataStatistics>();
            for (int j = 0; j < property.length; j++) {
                propertyDataStatistic.put(property[j], realTimeRegionDataMapper.dataStatistics(zoneMessageIntArray[i], property[j]));
            }
            linkedHashMap.put(zoneMessageIntArray[i], propertyDataStatistic);
        }
        if (linkedHashMap.isEmpty()) {
            return ServerResponse.createByErrorMessage("查不到数据");
        } else {
            return ServerResponse.createBySuccess(linkedHashMap);
        }
    }

}
