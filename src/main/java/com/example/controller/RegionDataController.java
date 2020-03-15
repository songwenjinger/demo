package com.example.controller;

import com.example.response.ServerResponse;
import com.example.service.RegionDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("regionData")
public class RegionDataController {
    @Autowired
    private RegionDataService regionDataService;

    @RequestMapping(value = "/queryRealTimeRegionData.do")
    public ServerResponse queryRealTimeRegionData(Integer id) {
        return regionDataService.queryRealTimeRegionData(id);
    }
}


