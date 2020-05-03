package com.example.service;

import com.example.entity.WarnMessage;

import java.text.ParseException;
import java.util.List;

/**
 * @ author: SongWenjing
 * @ Date 2020/5/3 9:54
 */
public interface WarnMessageQueryService {
    public List<WarnMessage> queryAll();

    public List<WarnMessage> queryByCondition(Integer zoneId, String startTime, String endTime) throws ParseException;
}
