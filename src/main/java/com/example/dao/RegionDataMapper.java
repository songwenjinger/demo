package com.example.dao;
/**
 * @author: SongWenjing
 * @Date 2020/4/3 17:24
 * 区域数据监测dao层接口
 */

import com.example.entity.RegionData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RegionDataMapper {
    /**
     * 根据区域的信息查找区域的实时数据，默认的是查找当前的一个小时内的数据
     *
     * @return
     */
    RegionData queryRealTimeRegionData(@Param("zoneId") Integer zoneId);
}
