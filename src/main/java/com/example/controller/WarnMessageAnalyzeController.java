package com.example.controller;

import com.example.service.WarnMessageAnalyzeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @ author: SongWenjing
 * @ Date 2020/5/3 22:23
 */
@Controller
@RequestMapping("/warnMessageAnalyze")
public class WarnMessageAnalyzeController {

    @Autowired
    WarnMessageAnalyzeService warnMessageAnalyzeService;

    @GetMapping(value = "/jumpWarnMessageAnalyze.do")
    public String jumpWarnMessageAnalyze() {
//        System.out.println("okok");
        return "WarnMessageAnalyze";
    }

    @GetMapping(value = "/jumpUserWarnMessageAnalyze.do")
    public String jumpUserWarnMessageAnalyze() {
//        System.out.println("okok");
        return "UserWarnMessageAnalyze";
    }

    @PostMapping(value = "/zoneCompare.do")
    @ResponseBody
    public Map<Object, Object> zoneCompare(String startTime, String endTime) throws ParseException {
        return warnMessageAnalyzeService.zoneCompare(startTime, endTime);
    }

    @PostMapping(value = "/reasonCompare.do")
    @ResponseBody
    public LinkedHashMap<Object, ArrayList<Object>> reasonCompare(Integer zoneId, String startTime,
                                                                  String endTime) throws ParseException {
        return warnMessageAnalyzeService.reasonCompare(zoneId, startTime, endTime);
    }

}
