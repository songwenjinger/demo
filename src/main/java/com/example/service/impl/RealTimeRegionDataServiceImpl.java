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
}
