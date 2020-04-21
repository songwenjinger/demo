package com.example.service.impl;

import com.example.entity.PropertyDataStatistics;
import com.example.dao.HistoryDataMapper;
import com.example.response.ServerResponse;
import com.example.service.HistoryDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author: SongWenjing
 * @Date 2020/4/16 10:39
 */
@Service
public class HistoryDataServiceImpl implements HistoryDataService {
    @Autowired
    HistoryDataMapper historyDataMapper;

    @Override
    public ServerResponse queryByUserDefined(Integer zoneId, String startTime, String endTime) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = sdf.parse(startTime);
        Date endDate = sdf.parse(endTime);
        List<PropertyDataStatistics> list = historyDataMapper.queryByUserDefined(zoneId, startDate, endDate);
        if (list == null) {
            return ServerResponse.createByErrorMessage("查不到数据");
        } else {
            return ServerResponse.createBySuccess(list);
        }
    }

    @Override
    public ServerResponse queryByWeek(Integer zoneId, Integer num) {
        List<PropertyDataStatistics> list = historyDataMapper.queryByWeek(zoneId, num);
        if (list == null) {
            return ServerResponse.createByErrorMessage("查不到数据");
        } else {
            return ServerResponse.createBySuccess(list);
        }
    }

    @Override
    public ServerResponse queryByMonth(Integer zoneId, Integer num) {
        List<PropertyDataStatistics> list = historyDataMapper.queryByMonth(zoneId, num);
        if (list == null) {
            return ServerResponse.createByErrorMessage("查不到数据");
        } else {
            return ServerResponse.createBySuccess(list);
        }
    }

    @Override
    public ServerResponse queryByYear(Integer zoneId, Integer num) {
        List<PropertyDataStatistics> list = historyDataMapper.queryByYear(zoneId, num);
        if (list == null) {
            return ServerResponse.createByErrorMessage("查不到数据");
        } else {
            return ServerResponse.createBySuccess(list);
        }
    }
}
