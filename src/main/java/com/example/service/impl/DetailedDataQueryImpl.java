package com.example.service.impl;

import com.example.dao.DetailedDataQueryMapper;
import com.example.entity.RegionData;
import com.example.service.DetailedDataQueryService;
import com.example.util.DateParse;
import com.example.util.TransformIntArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ author: SongWenjing
 * @ Date 2020/4/24 9:41
 */
@Service
public class DetailedDataQueryImpl implements DetailedDataQueryService {
    @Autowired
    DetailedDataQueryMapper detailedDataQueryMapper;

    @Override
    public List<RegionData> queryAll() {
        return detailedDataQueryMapper.queryAll();
    }

    @Override
    public List<RegionData> queryByCondition(Integer zoneId, String startTime, String endTime) throws ParseException {
        Date startDate = DateParse.parseDate(startTime);
        Date endDate = DateParse.parseDate(endTime);
        return detailedDataQueryMapper.queryByCondition(zoneId, startDate, endDate);
    }

    @Override
    public List<RegionData> queryByConditionOrderBySendTimeAsc(String zoneMessage, String startTime, String endTime) throws ParseException {
        List<RegionData> list = new ArrayList<>();
        int[] zoneMessageIntArray = TransformIntArray.transformIntArray(zoneMessage);
        for (int i = 0; i < zoneMessageIntArray.length; i++) {
            list.addAll(detailedDataQueryMapper.queryByConditionOrderBySendTimeAsc(zoneMessageIntArray[i],
                    DateParse.parseDate(startTime),
                    DateParse.parseDate(endTime)));
        }
        return list;
    }

    @Override
    public List<RegionData> queryByConditionOrderBySendTimeDesc(String zoneMessage, String startTime, String endTime) throws ParseException {
        List<RegionData> list = new ArrayList<>();
        int[] zoneMessageIntArray = TransformIntArray.transformIntArray(zoneMessage);
        for (int i = 0; i < zoneMessageIntArray.length; i++) {
            list.addAll(detailedDataQueryMapper.queryByConditionOrderBySendTimeDesc(zoneMessageIntArray[i],
                    DateParse.parseDate(startTime),
                    DateParse.parseDate(endTime)));
        }
        return list;
    }

    @Override
    public List<RegionData> queryByConditionOrderByZoneIdAsc(String zoneMessage, String startTime, String endTime) throws ParseException {
        List<RegionData> list = new ArrayList<>();
        int[] zoneMessageIntArray = TransformIntArray.transformIntArray(zoneMessage);
        for (int i = 0; i < zoneMessageIntArray.length; i++) {
            list.addAll(detailedDataQueryMapper.queryByConditionOrderByZoneIdAsc(zoneMessageIntArray[i],
                    DateParse.parseDate(startTime),
                    DateParse.parseDate(endTime)));
        }
        return list;
    }

    @Override
    public List<RegionData> queryByConditionOrderByZoneIdDesc(String zoneMessage, String startTime, String endTime) throws ParseException {
        List<RegionData> list = new ArrayList<>();
        int[] zoneMessageIntArray = TransformIntArray.transformIntArray(zoneMessage);
        for (int i = 0; i < zoneMessageIntArray.length; i++) {
            list.addAll(detailedDataQueryMapper.queryByConditionOrderByZoneIdDesc(zoneMessageIntArray[i],
                    DateParse.parseDate(startTime),
                    DateParse.parseDate(endTime)));
        }
        return list;
    }
}
