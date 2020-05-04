package com.example.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.sql.Array;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @ author: SongWenjing
 * @ Date 2020/5/3 11:27
 */
@Mapper
@Repository
public interface WarnMessageAnalyzeMapper {
    /**
     * 在一段时间里各个区域的出错的次数的对比
     * count*默认的返回值类型是long
     *
     * @return 对比次数
     */
    public List<LinkedHashMap<Object, Object>> zoneCompare(@Param("startTime") Date startTime, @Param("endTime") Date endTime);

    /**
     * 单个区域出错的原因的对比
     *
     * @param zoneId 区域id
     * @return 每一个原因的次数
     */
    public List<LinkedHashMap<Object, Object>> reasonCompare(@Param("zoneId") Integer zoneId,
                                                             @Param("startTime") Date startTime,
                                                             @Param("endTime") Date endTime);
}
