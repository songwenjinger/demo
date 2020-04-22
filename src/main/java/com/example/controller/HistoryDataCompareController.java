package com.example.controller;

import com.example.response.ServerResponse;
import com.example.service.HistoryDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.util.LinkedHashMap;

/**
 * @author: SongWenjing
 * @Date 2020/4/21 17:34
 */
@Controller
@RequestMapping("/historyDataCompare")
public class HistoryDataCompareController {
    @Autowired
    HistoryDataService historyDataService;

    @GetMapping(value = "/jumpHistoryDataCompare.do")
    public String jumpHistoryDataCompare() {
        return "HistoryDataCompare";
    }

    @PostMapping(value = "/queryMultiByUserDefined.do")
    @ResponseBody
    public ServerResponse queryMultiByUserDefined(String zoneMessage, String startTime, String endTime) throws ParseException {
        return historyDataService.queryMultiByUserDefined(zoneMessage, startTime, endTime);
    }

    @PostMapping(value = "/queryMultiByWeek.do")
    @ResponseBody
    public ServerResponse queryMultiByWeek(String zoneMessage, Integer num) throws ParseException {
        return historyDataService.queryMultiByWeek(zoneMessage, num);
    }

    @PostMapping(value = "/queryMultiByMonth.do")
    @ResponseBody
    public ServerResponse queryMultiByMonth(String zoneMessage, Integer num) {
        return historyDataService.queryMultiByMonth(zoneMessage, num);
    }

    @PostMapping(value = "/queryMultiByYear.do")
    @ResponseBody
    public ServerResponse queryMultiByYear(String zoneMessage, Integer num) {
        return historyDataService.queryMultiByYear(zoneMessage, num);
    }

    @PostMapping(value = "/queryMultiRecentSevenDays.do")
    @ResponseBody
    public ServerResponse queryMultiRecentSevenDays(String zoneMessage) {
        System.out.println("hhahah");
        return historyDataService.queryMultiRecentSevenDays(zoneMessage);
    }

}
