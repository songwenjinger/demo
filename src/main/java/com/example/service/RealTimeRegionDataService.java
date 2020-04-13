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
     * @return ServerResponse
     */
    ServerResponse dataStatistics(Integer zoneId);

    /**
     * 区域信息实时处理_根据传进来的string字符串，截取出需要对比的区域
     * @param zoneMessage controller层传来的字符串
     * @return ServerResponse
     */
    ServerResponse queryMultiTodayMessage(String zoneMessage);
}
