package com.example.dao;

import com.example.entity.RegionData;
import com.example.entity.RegionMes;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ author: SongWenjing
 * @ Date 2020/5/7 11:16
 */
@Mapper
@Repository
public interface RegionMesOperateMapper {
    /**
     * 查找出所有的信息
     *
     * @return List<RegionMes>
     */
    public List<RegionMes> queryAll();

    /**
     * 数据库中增加一条数据
     *
     * @param regionMes 实体
     * @return int
     */
    public int addRegionMes(@Param("regionMes") RegionMes regionMes);


    /**
     * 修改信息的状态为无效
     *
     * @param id     id
     * @param status 状态
     * @return int
     */
    public int updateStatus(@Param("id") Integer id, @Param("status") Integer status);

    /**
     * 更新信息
     *
     * @param regionMes regionMes
     * @return int
     */
    public int updateRegion(@Param("regionMes") RegionMes regionMes);
}
