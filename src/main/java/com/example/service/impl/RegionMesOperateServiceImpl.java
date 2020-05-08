package com.example.service.impl;

import com.example.dao.RegionMesOperateMapper;
import com.example.entity.RegionMes;
import com.example.service.RegionMesOperateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ author: SongWenjing
 * @ Date 2020/5/7 20:02
 */
@Service
public class RegionMesOperateServiceImpl implements RegionMesOperateService {
    @Autowired
    RegionMesOperateMapper regionMesOperateMapper;

    @Override
    public List<RegionMes> queryAll() {
        return regionMesOperateMapper.queryAll();
    }

    @Override
    public int addRegionMes(String zoneName, String brief, String phone, String email) {
        RegionMes regionMes = new RegionMes();
        regionMes.setZoneName(zoneName);
        regionMes.setBrief(brief);
        regionMes.setPhone(phone);
        regionMes.setEmail(email);
        regionMes.setStatus(1);
        return regionMesOperateMapper.addRegionMes(regionMes);
    }

    @Override
    public int updateStatus(Integer id, Integer status) {
        if (status == 0) {
            status = 1;
        } else if (status == 1) {
            status = 0;
        }
        return regionMesOperateMapper.updateStatus(id, status);
    }

    @Override
    public int updateRegion(Integer id, String zoneName, String brief, String phone, String email) {
        RegionMes regionMes = new RegionMes();
        regionMes.setId(id);
        regionMes.setZoneName(zoneName);
        regionMes.setBrief(brief);
        regionMes.setPhone(phone);
        regionMes.setEmail(email);
        return regionMesOperateMapper.updateRegion(regionMes);
    }
}
