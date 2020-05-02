package com.example.service;

import com.example.entity.PropertyDataStatistics;
import com.example.response.ServerResponse;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * @ author: SongWenjing
 * @ Date 2020/4/30 17:37
 */
public interface StatisticsDataQueryService {
    public List<PropertyDataStatistics> queryAll();

    public List<PropertyDataStatistics> queryByWeek(Integer zoneId, Integer num);

    public List<PropertyDataStatistics> queryByMonth(Integer zoneId, Integer num);

    public List<PropertyDataStatistics> queryByYear(Integer zoneId, Integer num);

    public List<PropertyDataStatistics> queryByUserDefined(Integer zoneId, String startTime, String endTime) throws ParseException;
}
