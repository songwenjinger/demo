package com.example.dao;

import com.example.entity.RegionData;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

/**
 * 数据统计，详细数据查询
 *
 * @ author: SongWenjing
 * @ Date 2020/4/23 9:18
 */
@Mapper
@Repository
public interface DetailedDataQueryMapper {
    /**
     * 查询出所有的结果，不分页
     * 同时可以根据zoneId和send_time进行升序和降序
     *
     * @return List<RegionData>
     */
    public List<RegionData> queryAll();

    /**
     * 按照条件查询
     *
     * @param zoneId    区域id
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @return List<RegionData>
     */
    public List<RegionData> queryByCondition(@RequestParam("zoneId") Integer zoneId,
                                             @RequestParam("startTime") Date startTime,
                                             @RequestParam("endTime") Date endTime);

    /**
     * 查询所有的信息,按照时间升序排列
     *
     * @return List<RegionData>
     */
    public List<RegionData> queryByConditionOrderBySendTimeAsc(@RequestParam("zoneId") Integer zoneId,
                                                               @RequestParam("startTime") Date startTime,
                                                               @RequestParam("endTime") Date endTime);

    /**
     * 查询所有的信息，按照时间降序排列
     *
     * @return List<RegionData>
     */
    public List<RegionData> queryByConditionOrderBySendTimeDesc(@RequestParam("zoneId") Integer zoneId,
                                                                @RequestParam("startTime") Date startTime,
                                                                @RequestParam("endTime") Date endTime);

    /**
     * 查询所有的信息，按照区域id升序排列
     *
     * @return List<RegionData>
     */
    public List<RegionData> queryByConditionOrderByZoneIdAsc(@RequestParam("zoneId") Integer zoneId,
                                                             @RequestParam("startTime") Date startTime,
                                                             @RequestParam("endTime") Date endTime);

    /**
     * 查询所有的信息，按照区域id降序排列
     *
     * @return List<RegionData>
     */
    public List<RegionData> queryByConditionOrderByZoneIdDesc(@RequestParam("zoneId") Integer zoneId,
                                                              @RequestParam("startTime") Date startTime,
                                                              @RequestParam("endTime") Date endTime);


}
