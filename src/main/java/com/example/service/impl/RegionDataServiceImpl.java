package com.example.service.impl;

import com.example.dao.RegionDataMapper;
import com.example.entity.RegionData;
import com.example.response.ServerResponse;
import com.example.service.RegionDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegionDataServiceImpl implements RegionDataService {
    @Autowired
    private RegionDataMapper regionDataMapper;

    /**
     * 最近一小时如果没有数据，前端展示为空
     *
     * @param id
     * @return
     */
    @Override
    public ServerResponse queryRealTimeRegionData(Integer id) {
        RegionData regionData = regionDataMapper.queryRealTimeRegionData(id);
        if (regionData == null) {
            return ServerResponse.createByErrorMessage("查不到数据");
        } else {
            return ServerResponse.createBySuccess(regionData);
        }
    }
}
