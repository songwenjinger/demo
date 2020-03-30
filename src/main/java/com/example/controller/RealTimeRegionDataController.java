package com.example.controller;

import com.example.response.ServerResponse;
import com.example.service.RealTimeRegionDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/realTimeRegionData")
public class RealTimeRegionDataController {
    @Autowired
    RealTimeRegionDataService realTimeRegionDataService;

    //    @PostMapping("/queryTodayMessage")
    @PostMapping("/queryTodayMessage.do")
    @ResponseBody
    public ServerResponse queryTodayMessage(Integer id) {
        System.out.println("ok");
        return realTimeRegionDataService.queryTodayMessage(id);
    }

    @PostMapping("/queryPaginationTodayMessage.do")
    @ResponseBody
    public ServerResponse queryPaginationTodayMessage(Integer zoneId, Integer startNum, Integer limitNum) {
        System.out.println("zoneId:" + zoneId + "startNum:" + startNum + "limitNum:" + limitNum);
        return realTimeRegionDataService.queryPaginationTodayMessage(zoneId, startNum, limitNum);
    }

    @PostMapping("/queryPaginationTodayMessageDescend.do")
    @ResponseBody
    public ServerResponse queryPaginationTodayMessageDescend(Integer zoneId, Integer startNum, Integer limitNum) {
        return realTimeRegionDataService.queryPaginationTodayMessageDescend(zoneId, startNum, limitNum);
    }


}
