package com.example.service.impl;

import com.example.dao.StatisticsDataQueryMapper;
import com.example.entity.PropertyDataStatistics;
import com.example.response.ServerResponse;
import com.example.service.StatisticsDataQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ author: SongWenjing
 * @ Date 2020/4/30 17:37
 */
@Service
public class StatisticsDataQueryServiceImpl implements StatisticsDataQueryService {
    @Autowired
    StatisticsDataQueryMapper statisticsDataQueryMapper;

    @Override
    public List<PropertyDataStatistics> queryAll() {
        List<PropertyDataStatistics> list = statisticsDataQueryMapper.queryAll();
        if (list == null) {
            return null;
        } else {
            return list;
        }
    }
}
