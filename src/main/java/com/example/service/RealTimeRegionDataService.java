package com.example.service;

import com.example.response.ServerResponse;

public interface RealTimeRegionDataService {
    ServerResponse queryTodayMessage(Integer id);

    ServerResponse queryPaginationTodayMessage(Integer zoneId, Integer startNum, Integer limitNum);

    ServerResponse queryPaginationTodayMessageDescend(Integer zoneId, Integer startNum, Integer limitNum);
}
