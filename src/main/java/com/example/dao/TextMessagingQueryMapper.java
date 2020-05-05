package com.example.dao;

import com.example.entity.TextMessaging;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @ author: SongWenjing
 * @ Date 2020/5/4 16:15
 */
@Mapper
@Repository
public interface TextMessagingQueryMapper {
    public List<TextMessaging> queryAll();

    public List<TextMessaging> queryByCondition(@Param("zoneId") Integer zoneId,
                                                @Param("startTime") Date startTime,
                                                @Param("endTime") Date endTime);
}
