package com.example.controller;

import com.example.entity.RegionData;
import com.example.service.DetailedDataQueryService;
import com.example.util.OperateCookies;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ author: SongWenjing
 * @ Date 2020/4/24 9:45
 */
@Controller
@RequestMapping("/detailedDataQuery")
public class DetailedDataQueryController {
    @Autowired
    DetailedDataQueryService detailedDataQueryService;


    @PostMapping(value = "/fillTableInit.do")
    @ResponseBody
    public List<RegionData> fillTableInit(@RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum,
                                          Integer zoneId, String startTime, String endTime) throws ParseException {
        PageHelper.startPage(pageNum, 8);
        return detailedDataQueryService.queryByCondition(zoneId, startTime, endTime);
    }

    /**
     * 查询所有信息
     *
     * @param model   视图
     * @param pageNum 分页的页数
     * @return 返回一个前端页面
     */
    @GetMapping(value = "/queryAll.do")
    public String queryAll(Model model, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) {
        PageHelper.startPage(pageNum, 8);
        List<RegionData> list = detailedDataQueryService.queryAll();
        PageInfo<RegionData> pageInfo = new PageInfo<RegionData>(list);
        model.addAttribute("pageInfo", pageInfo);
        return "DetailedDataQuery";
    }

    /**
     * 如果是刚点击进来，就查询所有的，点击查询按钮之后，按照条件查询
     *
     * @param model     视图
     * @param pageNum   页数
     * @param zoneId    区域id
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @return 页面
     * @throws ParseException
     */
    @PostMapping(value = "/queryByCondition.do")
    public String queryByCondition(Model model, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum,
                                   Integer zoneId, String startTime, String endTime) throws ParseException {
        List<RegionData> list;
        if (startTime == null || startTime.equals("")) {
            PageHelper.startPage(pageNum, 8);
            list = detailedDataQueryService.queryAll();
        } else {
            PageHelper.startPage(pageNum, 8);
            list = detailedDataQueryService.queryByCondition(zoneId, startTime, endTime);
        }
        PageInfo<RegionData> pageInfo = new PageInfo<RegionData>(list);
        model.addAttribute("pageInfo", pageInfo);
        return "DetailedDataQuery";
    }

    @PostMapping(value = "/queryByConditionOrderBySendTimeAsc.do")
    public String queryByConditionOrderBySendTimeAsc(Model model, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum,
                                                     String zoneMessage, String startTime, String endTime) throws ParseException {
        PageHelper.startPage(pageNum, 8);
        List<RegionData> list = detailedDataQueryService.queryByConditionOrderBySendTimeAsc(zoneMessage, startTime, endTime);
        PageInfo<RegionData> pageInfo = new PageInfo<RegionData>(list);
        model.addAttribute("pageInfo", pageInfo);
        return "DetailedDataQuery";
    }

    @PostMapping(value = "/queryByConditionOrderBySendTimeDesc.do")
    public String queryByConditionOrderBySendTimeDesc(Model model, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum,
                                                      String zoneMessage, String startTime, String endTime) throws ParseException {
        PageHelper.startPage(pageNum, 8);
        List<RegionData> list = detailedDataQueryService.queryByConditionOrderBySendTimeDesc(zoneMessage, startTime, endTime);
        PageInfo<RegionData> pageInfo = new PageInfo<RegionData>(list);
        model.addAttribute("pageInfo", pageInfo);
        return "DetailedDataQuery";
    }

    @PostMapping(value = "/queryByConditionOrderByZoneIdAsc.do")
    public String queryByConditionOrderByZoneIdAsc(Model model, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum,
                                                   String zoneMessage, String startTime, String endTime) throws ParseException {
        PageHelper.startPage(pageNum, 8);
        List<RegionData> list = detailedDataQueryService.queryByConditionOrderByZoneIdAsc(zoneMessage, startTime, endTime);
        PageInfo<RegionData> pageInfo = new PageInfo<RegionData>(list);
        model.addAttribute("pageInfo", pageInfo);
        return "DetailedDataQuery";
    }

    @PostMapping(value = "/queryByConditionOrderByZoneIdDesc.do")
    public String queryByConditionOrderByZoneIdDesc(Model model, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum,
                                                    String zoneMessage, String startTime, String endTime) throws ParseException {
        PageHelper.startPage(pageNum, 8);
        List<RegionData> list = detailedDataQueryService.queryByConditionOrderByZoneIdDesc(zoneMessage, startTime, endTime);
        PageInfo<RegionData> pageInfo = new PageInfo<RegionData>(list);
        model.addAttribute("pageInfo", pageInfo);
        return "DetailedDataQuery";
    }

    /**
     * 获取cookie的值，得到对应的页面，返回
     *
     * @return
     */
    @RequestMapping(value = "/jumpToDetailedDataQuery.do")
    public String jumpToDetailedDataQuery(Model model, HttpServletRequest httpServletRequest, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) throws ParseException {
        String startTime = "2020-01-01";
        String endTime = "2020-06-01";
        Integer zoneId = OperateCookies.getZoneIdCookie(httpServletRequest);
        PageHelper.startPage(pageNum, 8);
        List<RegionData> list = detailedDataQueryService.queryByCondition(zoneId, startTime, endTime);
        PageInfo<RegionData> pageInfo = new PageInfo<RegionData>(list);
        model.addAttribute("pageInfo", pageInfo);
        return "DetailedDataQuery";
    }


}
