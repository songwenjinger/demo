package com.example.service.impl;

import com.example.dao.DetailedDataQueryMapper;
import com.example.entity.RegionData;
import com.example.service.DetailedDataQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
