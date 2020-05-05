package com.example.service;

import com.example.entity.TextMessaging;

import java.text.ParseException;
import java.util.List;

/**
 * @ author: SongWenjing
 * @ Date 2020/5/4 16:39
 */
public interface TextMessagingQueryService {
    public List<TextMessaging> queryAll();

    public List<TextMessaging> queryByCondition(Integer zoneId, String startTime, String endTime) throws ParseException;
}
