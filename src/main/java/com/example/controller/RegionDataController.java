package com.example.controller;

import com.example.response.ServerResponse;
import com.example.service.RegionDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/regionData")
public class RegionDataController {
    @Autowired
    private RegionDataService regionDataService;

    @GetMapping(value = "/queryRealTimeRegionData.do")

    public ServerResponse queryRealTimeRegionData(Integer id) {
        return regionDataService.queryRealTimeRegionData(id);
    }

    @GetMapping(value = "/jumpRealTimeRegionData.do")
    public String jumpRealTimeRegionData() {
        return "RealTimeRegionData";
    }

    @GetMapping(value = "/jumpRealTimeTable.do")
    @RequestMapping(method = RequestMethod.GET)
    public String jumpRealTimeTable() {
        return "realTimeTable";
    }

}


