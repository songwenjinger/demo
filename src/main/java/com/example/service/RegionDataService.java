package com.example.service;

import com.example.entity.RegionData;
import com.example.response.ServerResponse;

public interface RegionDataService {
    ServerResponse queryRealTimeRegionData(Integer id);
}
