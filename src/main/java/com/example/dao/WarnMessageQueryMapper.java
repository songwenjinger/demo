package com.example.dao;

import com.example.entity.WarnMessage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * 预警信息查询
 *
 * @ author: SongWenjing
 * @ Date 2020/5/3 9:20
 */
@Mapper
@Repository
public interface WarnMessageQueryMapper {
    /**
     * 查询所有的信息
     *
     * @return List<WarnMessage>
     */
    public List<WarnMessage> queryAll();

    /**
     * 按照条件查询
     *
     * @param zoneId    区域id
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @return List<WarnMessage>
     */

    public List<WarnMessage> queryByCondition(@Param("zoneId") Integer zoneId,
                                              @Param("startTime") Date startTime,
                                              @Param("endTime") Date endTime);
}
