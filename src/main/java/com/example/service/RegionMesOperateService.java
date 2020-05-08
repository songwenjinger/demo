package com.example.service;

import com.example.entity.RegionMes;
import org.apache.catalina.LifecycleState;

import java.util.List;

/**
 * @ author: SongWenjing
 * @ Date 2020/5/7 20:01
 */
public interface RegionMesOperateService {
    public List<RegionMes> queryAll();

    public int addRegionMes(RegionMes regionMes);

    public int updateStatus(Integer id, Integer status);

    public int updateRegion(Integer id, String zoneName, String brief, String phone, String email);

}
