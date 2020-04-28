package com.example.dao;

import com.example.entity.RegionData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

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
     * 查询所有的信息,并分页
     * 刚开始进入页面调用的接口
     *
     * @param limitNum 查询截止的数字
     * @return List<RegionData>
     */
    public List<RegionData> queryAllByPaginationOrderBySendTimeAsc(@Param("startNum") Integer startNum, @Param("limitNum") Integer limitNum);

    /**
     * 分页按照条件查询
     *
     * @param regionData 查询条件
     * @return List<RegionData>
     */
    public List<RegionData> queryByParamPaginationOrderByZoneIdDesc(@Param("regionData") RegionData regionData);

    /**
     * 查询符合条件的条数
     *
     * @param regionData 查询条件
     * @return List<RegionData>
     */
    public Integer queryCount(@Param("regionData") RegionData regionData);

}
