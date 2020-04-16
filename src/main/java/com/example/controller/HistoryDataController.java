package com.example.controller;

import com.example.response.ServerResponse;
import com.example.service.HistoryDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.rmi.ServerError;
import java.util.Date;

/**
 * @author: SongWenjing
 * @Date 2020/4/16 10:48
 */
@Controller
@RequestMapping("/historyData")
public class HistoryDataController {
    @Autowired
    HistoryDataService historyDataService;

    @PostMapping(value = "/queryByUserDefined.do")
    @ResponseBody
    ServerResponse queryByUserDefined(Integer zoneId, Date startTime, Date endTime) {
        return historyDataService.queryByUserDefined(zoneId, startTime, endTime);
    }

    @PostMapping(value = "/queryByWeek.do")
    @ResponseBody
    ServerResponse queryByWeek(Integer zoneId, Integer num) {
        return historyDataService.queryByWeek(zoneId, num);
    }

    @PostMapping(value = "/queryByMonth.do")
    @ResponseBody
    ServerResponse queryByMonth(Integer zoneId, Integer num) {
        return historyDataService.queryByMonth(zoneId, num);
    }

    @PostMapping(value = "/queryByYear.do")
    @ResponseBody
    ServerResponse queryByYear(Integer zoneId, Integer num) {
        return historyDataService.queryByYear(zoneId, num);
    }

}