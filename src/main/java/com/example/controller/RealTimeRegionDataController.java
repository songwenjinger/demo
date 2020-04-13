package com.example.controller;
/**
 * @author: SongWenjing
 * @Date 2020/4/3 17:24
 * 区域数据监测_实时数据监测页面
 * 区域数据监测_区域参数对比页面
 */

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

    /**
     * 查询当天的信息
     *
     * @param id 传入的区域id
     * @return ServerResponse
     */
    @PostMapping("/queryTodayMessage.do")
    @ResponseBody
    public ServerResponse queryTodayMessage(Integer id) {
        return realTimeRegionDataService.queryTodayMessage(id);
    }

    /**
     * 分页查询当天的信息
     *
     * @param zoneId   区域id
     * @param startNum 开始的条数
     * @param limitNum 限制的条数
     * @return ServerResponse
     */
    @PostMapping("/queryPaginationTodayMessage.do")
    @ResponseBody
    public ServerResponse queryPaginationTodayMessage(Integer zoneId, Integer startNum, Integer limitNum) {
        System.out.println("zoneId:" + zoneId + "startNum:" + startNum + "limitNum:" + limitNum);
        return realTimeRegionDataService.queryPaginationTodayMessage(zoneId, startNum, limitNum);
    }

    /**
     * 分页查询当天的信息，按照发送时间进行降序排列
     *
     * @param zoneId   区域id
     * @param startNum 开始条数
     * @param limitNum 限制的条数
     * @return ServerResponse
     */
    @PostMapping("/queryPaginationTodayMessageDescend.do")
    @ResponseBody
    public ServerResponse queryPaginationTodayMessageDescend(Integer zoneId, Integer startNum, Integer limitNum) {
        return realTimeRegionDataService.queryPaginationTodayMessageDescend(zoneId, startNum, limitNum);
    }

    /**
     * 查询最大值，最小值，平均值，累加和
     *
     * @param zoneId 区域id
     * @return ServerResponse
     */
    @PostMapping("/queryDataStatistics.do")
    @ResponseBody
    public ServerResponse queryDataStatistics(Integer zoneId) {
        return realTimeRegionDataService.dataStatistics(zoneId);
    }


}
