package com.example.dao;


import com.example.entity.RegionData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 根据区域的信息查找区域的实时数据，默认的是查找当前的一个小时内的数据
 *
 * @return
 */
@Mapper
@Repository
public interface RealTimeRegionDataMapper {
    List<RegionData> queryTodayMessage(@Param("zoneId") Integer zoneId);

    List<RegionData> queryPaginationTodayMessage(@Param("zoneId") Integer zoneId, @Param("startNum") Integer startNum,
                                                 @Param("limitNum") Integer limitNum);

    /**
     * 按照发送的时间进行的降序的排列
     *
     * @param zoneId   区域id
     * @param startNum 开始的条数
     * @param limitNum 一共几条
     * @return list
     */
    List<RegionData> queryPaginationTodayMessageDescend(@Param("zoneId") Integer zoneId, @Param("startNum") Integer startNum,
                                                        @Param("limitNum") Integer limitNum);
}
