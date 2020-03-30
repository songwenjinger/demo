package com.example.service.impl;

import com.example.dao.RealTimeRegionDataMapper;
import com.example.entity.RegionData;
import com.example.response.ServerResponse;
import com.example.service.RealTimeRegionDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
