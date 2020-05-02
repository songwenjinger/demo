package com.example.service.impl;

import com.example.dao.StatisticsDataQueryMapper;
import com.example.entity.PropertyDataStatistics;
import com.example.response.ServerResponse;
import com.example.service.StatisticsDataQueryService;
import com.example.util.DateParse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;
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

    @Override
    public List<PropertyDataStatistics> queryByWeek(Integer zoneId, Integer num) {
        return statisticsDataQueryMapper.queryByWeek(zoneId, num);
    }

    @Override
    public List<PropertyDataStatistics> queryByMonth(Integer zoneId, Integer num) {
        return statisticsDataQueryMapper.queryByMonth(zoneId, num);
    }

    @Override
    public List<PropertyDataStatistics> queryByYear(Integer zoneId, Integer num) {
        return statisticsDataQueryMapper.queryByYear(zoneId, num);
    }

    @Override
    public List<PropertyDataStatistics> queryByUserDefined(Integer zoneId, String startTime, String endTime) throws ParseException {
        return statisticsDataQueryMapper.queryByUserDefined(zoneId, DateParse.parseDate(startTime), DateParse.parseDate(endTime));
    }
}
