package com.example.service.impl;

import com.example.dao.WarnMessageQueryMapper;
import com.example.entity.WarnMessage;
import com.example.service.WarnMessageQueryService;
import com.example.util.DateParse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

/**
 * @ author: SongWenjing
 * @ Date 2020/5/3 9:55
 */
@Service
public class WarnMessageQueryServiceImpl implements WarnMessageQueryService {
    @Autowired
    WarnMessageQueryMapper warnMessageQueryMapper;

    @Override
    public List<WarnMessage> queryAll() {
        return warnMessageQueryMapper.queryAll();
    }

    @Override
    public List<WarnMessage> queryByCondition(Integer zoneId, String startTime, String endTime) throws ParseException {
        return warnMessageQueryMapper.queryByCondition(zoneId, DateParse.parseDate(startTime), DateParse.parseDate(endTime));
    }
}
