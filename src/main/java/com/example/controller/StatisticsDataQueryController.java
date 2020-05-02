package com.example.controller;

import com.example.entity.PropertyDataStatistics;
import com.example.entity.RegionData;
import com.example.service.DetailedDataQueryService;
import com.example.service.StatisticsDataQueryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

/**
 * @ author: SongWenjing
 * @ Date 2020/4/24 9:45
 */
@Controller
@RequestMapping("/statisticsDataQuery")
public class StatisticsDataQueryController {
    @Autowired
    StatisticsDataQueryService statisticsDataQueryService;

    @GetMapping(value = "/queryAll.do")
    public String queryAll(Model model, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) {
        PageHelper.startPage(pageNum, 8);
        List<PropertyDataStatistics> list = statisticsDataQueryService.queryAll();
        PageInfo<PropertyDataStatistics> pageInfo = new PageInfo<PropertyDataStatistics>(list);
        model.addAttribute("pageInfo", pageInfo);
        return "StatisticsDataQuery";
    }

    @PostMapping(value = "/queryByWeek.do")
    public String queryByWeek(Model model, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum,
                              Integer zoneId, Integer num) throws ParseException {
        PageHelper.startPage(pageNum, 8);
        List<PropertyDataStatistics> list = statisticsDataQueryService.queryByWeek(zoneId, num);
        PageInfo<PropertyDataStatistics> pageInfo = new PageInfo<PropertyDataStatistics>(list);
        model.addAttribute("pageInfo", pageInfo);
        return "StatisticsDataQuery";
    }

    @PostMapping(value = "/queryByMonth.do")
    public String queryByMonth(Model model, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum,
                               Integer zoneId, Integer num) throws ParseException {
        PageHelper.startPage(pageNum, 8);
        List<PropertyDataStatistics> list = statisticsDataQueryService.queryByMonth(zoneId, num);
        PageInfo<PropertyDataStatistics> pageInfo = new PageInfo<PropertyDataStatistics>(list);
        model.addAttribute("pageInfo", pageInfo);
        return "StatisticsDataQuery";
    }

    @PostMapping(value = "/queryByYear.do")
    public String queryByYear(Model model, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum,
                              Integer zoneId, Integer num) throws ParseException {
        PageHelper.startPage(pageNum, 8);
        List<PropertyDataStatistics> list = statisticsDataQueryService.queryByYear(zoneId, num);
        PageInfo<PropertyDataStatistics> pageInfo = new PageInfo<PropertyDataStatistics>(list);
        model.addAttribute("pageInfo", pageInfo);
        return "StatisticsDataQuery";
    }

    @PostMapping(value = "/queryByUserDefined.do")
    public String queryByUserDefined(Model model, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum,
                                     Integer zoneId, String startTime, String endTime) throws ParseException {
        PageHelper.startPage(pageNum, 8);
        List<PropertyDataStatistics> list = statisticsDataQueryService.queryByUserDefined(zoneId, startTime, endTime);
        PageInfo<PropertyDataStatistics> pageInfo = new PageInfo<PropertyDataStatistics>(list);
        model.addAttribute("pageInfo", pageInfo);
        return "StatisticsDataQuery";
    }

   /* public List<PropertyDataStatistics> judge(String )
    {
        if (startTime == null || startTime.equals("")) {
            PageHelper.startPage(pageNum, 8);
            list = detailedDataQueryService.queryAll();
        }
    }*/

}
