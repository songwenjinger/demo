package com.example.service.impl;

import com.example.auxiliary.DataStatistics;
import com.example.dao.RealTimeRegionDataMapper;
import com.example.entity.RegionData;
import com.example.response.ServerResponse;
import com.example.service.RealTimeRegionDataService;
import org.apache.catalina.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@Service
public class RealTimeRegionDataServiceImpl implements RealTimeRegionDataService {
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
        dataStatisticsLinkedHashMap.put("waterTemperature", realTimeRegionDataMapper.dataStatistics(zoneId, "water_temperature"));
        dataStatisticsLinkedHashMap.put("ph", realTimeRegionDataMapper.dataStatistics(zoneId, "ph"));
        dataStatisticsLinkedHashMap.put("cod", realTimeRegionDataMapper.dataStatistics(zoneId, "cod"));
        dataStatisticsLinkedHashMap.put("nh3", realTimeRegionDataMapper.dataStatistics(zoneId, "nh3"));
        dataStatisticsLinkedHashMap.put("dox", realTimeRegionDataMapper.dataStatistics(zoneId, "dox"));
        dataStatisticsLinkedHashMap.put("conductivity", realTimeRegionDataMapper.dataStatistics(zoneId, "conductivity"));
        dataStatisticsLinkedHashMap.put("turbidity", realTimeRegionDataMapper.dataStatistics(zoneId, "turbidity"));
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
        String[] zoneMessageArray = zoneMessage.split(",");
        LinkedHashMap<Integer, List<RegionData>> linkedHashMap = new LinkedHashMap<Integer, List<RegionData>>();
        int[] zoneMessageIntArray = new int[zoneMessageArray.length];
        for (int i = 0; i < zoneMessageArray.length; i++) {
            zoneMessageIntArray[i] = Integer.parseInt(zoneMessageArray[i]);
        }
        for (int i = 0; i < zoneMessageIntArray.length; i++) {
            linkedHashMap.put(zoneMessageIntArray[i], realTimeRegionDataMapper.queryTodayMessage(zoneMessageIntArray[i]));
        }
        if (linkedHashMap.isEmpty()) {
            return ServerResponse.createByErrorMessage("查不到数据");
        } else {
            return ServerResponse.createBySuccess(linkedHashMap);
        }
    }
}
