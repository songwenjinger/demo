package com.example.service.impl;

import com.example.dao.TextMessagingQueryMapper;
import com.example.entity.TextMessaging;
import com.example.service.TextMessagingQueryService;
import com.example.util.DateParse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

/**
 * @ author: SongWenjing
 * @ Date 2020/5/4 16:41
 */
@Service
public class TextMessagingQueryServiceImpl implements TextMessagingQueryService {
    @Autowired
    TextMessagingQueryMapper textMessagingQueryMapper;

    @Override
    public List<TextMessaging> queryAll() {
        return textMessagingQueryMapper.queryAll();
    }

    @Override
    public List<TextMessaging> queryByCondition(Integer zoneId, String startTime, String endTime) throws ParseException {
        return textMessagingQueryMapper.queryByCondition(zoneId, DateParse.parseDate(startTime), DateParse.parseDate(endTime));
    }
}
