package com.example.controller;

import com.example.response.ServerResponse;
import com.example.service.RealTimeRegionDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: SongWenjing
 * @Date 2020/4/7 20:43
 * 数据实时监测_区域信息对比页面
 */
@Controller
@RequestMapping("/realDataCompare")
public class RealDataCompare {
    @Autowired
    RealTimeRegionDataService realTimeRegionDataService;

    @GetMapping(value = "/jumpRealDataCompare.do")
    public String jumpRealTimeRegionData() {
        System.out.println("RealDataCompare");
        return "RealDataCompare";
    }

    @PostMapping(value = "/queryMultiTodayMessage.do")
    @ResponseBody
    public ServerResponse queryMultiTodayMessage(String zoneMessage) {
        System.out.println(zoneMessage);
        return realTimeRegionDataService.queryMultiTodayMessage(zoneMessage);
    }

    @PostMapping(value = "/queryMultiTodayDataStatistics.do")
    @ResponseBody
    public ServerResponse queryMultiTodayDataStatistics(String zoneMessage) {
        return realTimeRegionDataService.queryMultiDataStatistics(zoneMessage);
    }

}
