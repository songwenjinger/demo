package com.example.dao;

import com.example.entity.PropertyDataStatistics;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @author: SongWenjing
 * @Date 2020/4/15 21:58
 * 历史数据查询页面
 */
@Mapper
@Repository
public interface HistoryDataMapper {
    /**
     * 通过自定义的开始时间和结束时间来查找
     *
     * @param zoneId    区域号
     * @param startTime 开始时间
     * @param endTime   截止时间
     * @return DataStatistics
     */
    List<PropertyDataStatistics> queryByUserDefined(@Param("zoneId") Integer zoneId,
                                                    @Param("startTime") Date startTime,
                                                    @Param("endTime") Date endTime);

    /**
     * 按照周来查询
     *
     * @param zoneId 区域号
     * @param num    最近几周
     * @return DataStatistics
     */
    List<PropertyDataStatistics> queryByWeek(@Param("zoneId") Integer zoneId, @Param("num") Integer num);

    /**
     * 查询最近一个月的数据
     *
     * @param zoneId 区域号
     * @param num    最近几月
     * @return DataStatistics
     */
    List<PropertyDataStatistics> queryByMonth(@Param("zoneId") Integer zoneId, @Param("num") Integer num);

    /**
     * 查询最近一年的数据
     *
     * @param zoneId 区域号
     * @param num    最近几年
     * @return DataStatistics
     */
    List<PropertyDataStatistics> queryByYear(@Param("zoneId") Integer zoneId, @Param("num") Integer num);

    /**
     * 查询最近七天的数据
     * @param zoneId
     * @return
     */
    List<PropertyDataStatistics> queryRecentSevenDays(@Param("zoneId") Integer zoneId);
}
