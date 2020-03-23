package com.example.controller;

import com.example.response.ServerResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/realTimeRegionData")
public class RealTimeRegionDataController {
    @PostMapping("/queryTodayMessage")
    @ResponseBody
    public ServerResponse queryTodayMessage() {
        return null;
    }

}
