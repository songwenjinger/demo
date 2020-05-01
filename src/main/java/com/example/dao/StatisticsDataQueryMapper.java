package com.example.dao;

import com.example.entity.PropertyDataStatistics;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 数据统计页面，统计数据查询
 *
 * @ author: SongWenjing
 * @ Date 2020/4/30 17:28
 */
@Mapper
@Repository
public interface StatisticsDataQueryMapper {
    public List<PropertyDataStatistics> queryAll();
}
