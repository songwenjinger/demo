package com.example.service;

import com.example.response.ServerResponse;

import java.util.Date;

/**
 * 历史数据查询service
 *
 * @author: SongWenjing
 * @Date 2020/4/16 10:36
 */
public interface HistoryDataService {
    ServerResponse queryByUserDefined(Integer zoneId, Date StartTime, Date endTime);

    ServerResponse queryByWeek(Integer zoneId, Integer num);

    ServerResponse queryByMonth(Integer zoneId, Integer num);

    ServerResponse queryByYear(Integer zoneId, Integer num);
}
