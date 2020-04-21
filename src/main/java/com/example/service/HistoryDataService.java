package com.example.service;

import com.example.response.ServerResponse;

import java.text.ParseException;
import java.util.Date;

/**
 * 历史数据查询service
 *
 * @author: SongWenjing
 * @Date 2020/4/16 10:36
 */
public interface HistoryDataService {
    ServerResponse queryByUserDefined(Integer zoneId, String StartTime, String endTime) throws ParseException;

    ServerResponse queryByWeek(Integer zoneId, Integer num);

    ServerResponse queryByMonth(Integer zoneId, Integer num);

    ServerResponse queryByYear(Integer zoneId, Integer num);

    ServerResponse queryRecentSevenDays(Integer zoneId);

    /**
     * 多个区域历史参数的对比
     *
     * @param zoneMessage input框中的string类型的信息
     * @return ServerResponse
     */
    ServerResponse queryMultiByUserDefined(String zoneMessage, String startTime, String endTime) throws ParseException;

    ServerResponse queryMultiByWeek(String zoneMessage, Integer num);

    ServerResponse queryMultiByMonth(String zoneMessage, Integer num);

    ServerResponse queryMultiByYear(String zoneMessage, Integer num);

    ServerResponse queryMultiRecentSevenDays(String zoneMessage);
}
