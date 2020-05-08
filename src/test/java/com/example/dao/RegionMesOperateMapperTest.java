package com.example.dao;

import com.example.entity.RegionMes;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Iterator;
import java.util.List;

/**
 * @ author: SongWenjing
 * @ Date 2020/5/7 11:44
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RegionMesOperateMapperTest {
    @Autowired
    RegionMesOperateMapper regionMesOperateMapper;

    @Test
    public void testQueryAll() {
        List<RegionMes> list = regionMesOperateMapper.queryAll();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void testInsert() {
        RegionMes regionMes = new RegionMes();
        regionMes.setZoneName("H公司");
        regionMes.setBrief("x号园区");
        regionMes.setPhone("12345678910");
        regionMes.setEmail("12345678910@163.com");
        regionMes.setStatus(0);
        int result = regionMesOperateMapper.addRegionMes(regionMes);
        System.out.println(result);
    }

    @Test
    public void testUpdateStatus() {
        int result = regionMesOperateMapper.updateStatus(10, 1);
        System.out.println(result);
    }

    @Test
    public void testUpdateRegionMes() {
        RegionMes regionMes = new RegionMes();
        regionMes.setId(9);
        regionMes.setZoneName("y区域");
        regionMes.setPhone("99999999999");
        regionMes.setBrief("小小区");
        regionMes.setEmail("22345678910@163.com");
        int result = regionMesOperateMapper.updateRegion(regionMes);
        System.out.println(result);
    }

}
