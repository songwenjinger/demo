package com.example.service;

import com.example.response.ServerResponse;

public interface RealTimeRegionDataService {
    ServerResponse queryTodayMessage(Integer id);

    ServerResponse queryPaginationTodayMessage(Integer zoneId, Integer startNum, Integer limitNum);

    ServerResponse queryPaginationTodayMessageDescend(Integer zoneId, Integer startNum, Integer limitNum);

    /**
     * 统计七个参数的值
     * 最大值，最小值，累加和，平均值
     *
     * @return  ServerResponse
     */
    ServerResponse dataStatistics(Integer zoneId);
}
