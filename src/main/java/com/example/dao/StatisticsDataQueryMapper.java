package com.example.dao;

import com.example.entity.PropertyDataStatistics;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
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

    /**
     * 按照条件查询
     *
     * @param zoneId 区域id
     * @return List<RegionData>
     */
    public List<PropertyDataStatistics> queryByWeek(@Param("zoneId") Integer zoneId,
                                                    @Param("num") Integer num);

    public List<PropertyDataStatistics> queryByMonth(@Param("zoneId") Integer zoneId,
                                                     @Param("num") Integer num);

    public List<PropertyDataStatistics> queryByYear(@Param("zoneId") Integer zoneId,
                                                    @Param("num") Integer num);

    public List<PropertyDataStatistics> queryByUserDefined(@Param("zoneId") Integer zoneId,
                                                           @Param("startTime") Date startTime,
                                                           @Param("endTime") Date endTime);


}
