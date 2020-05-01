package com.example.service;

import com.example.entity.PropertyDataStatistics;
import com.example.response.ServerResponse;

import java.util.List;

/**
 * @ author: SongWenjing
 * @ Date 2020/4/30 17:37
 */
public interface StatisticsDataQueryService {
    public List<PropertyDataStatistics> queryAll();
}
