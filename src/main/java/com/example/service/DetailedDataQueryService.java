package com.example.service;

import com.example.entity.RegionData;

import java.text.ParseException;
import java.util.List;

/**
 * @ author: SongWenjing
 * @ String 2020/4/24 9:41
 */
public interface DetailedDataQueryService {
    public List<RegionData> queryAll();

    /**
     * 按照条件查询
     *
     * @param zoneId 区域id
     * @param startTime   开始时间
     * @param endTime     结束时间
     * @return List<RegionData>
     */
    public List<RegionData> queryByCondition(Integer zoneId, String startTime, String endTime) throws ParseException;

    /**
     * 查询所有的信息,按照时间升序排列
     *
     * @return List<RegionData>
     */
    public List<RegionData> queryByConditionOrderBySendTimeAsc(String zoneMessage, String startTime, String endTime) throws ParseException;

    /**
     * 查询所有的信息，按照时间降序排列
     *
     * @return List<RegionData>
     */
    public List<RegionData> queryByConditionOrderBySendTimeDesc(String zoneMessage, String startTime, String endTime) throws ParseException;

    /**
     * 查询所有的信息，按照区域id升序排列
     *
     * @return List<RegionData>
     */
    public List<RegionData> queryByConditionOrderByZoneIdAsc(String zoneMessage, String startTime, String endTime) throws ParseException;

    /**
     * 查询所有的信息，按照区域id降序排列
     *
     * @return List<RegionData>
     */
    public List<RegionData> queryByConditionOrderByZoneIdDesc(String zoneMessage, String startTime, String endTime) throws ParseException;

}
