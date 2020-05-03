package com.example.controller;

import com.example.entity.RegionData;
import com.example.entity.WarnMessage;
import com.example.service.WarnMessageQueryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.util.List;

/**
 * @ author: SongWenjing
 * @ Date 2020/5/3 10:02
 */
@Controller
@RequestMapping("/warnMessageQuery")
public class WarnMessageQueryController {
    @Autowired
    WarnMessageQueryService warnMessageQueryService;

    @GetMapping(value = "/queryAll.do")
    public String queryAll(Model model, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) {
        PageHelper.startPage(pageNum, 8);
        List<WarnMessage> list = warnMessageQueryService.queryAll();
        PageInfo<WarnMessage> pageInfo = new PageInfo<WarnMessage>(list);
        model.addAttribute("pageInfo", pageInfo);
        return "WarnMessageQuery";
    }


    @PostMapping(value = "/queryByCondition.do")
    public String queryByCondition(Model model, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum,
                                   Integer zoneId, String startTime, String endTime) throws ParseException {
        List<WarnMessage> list;
        if (startTime == null || startTime.equals("")) {
            PageHelper.startPage(pageNum, 8);
            list = warnMessageQueryService.queryAll();
        } else {
            PageHelper.startPage(pageNum, 8);
            list = warnMessageQueryService.queryByCondition(zoneId, startTime, endTime);
        }
        PageInfo<WarnMessage> pageInfo = new PageInfo<WarnMessage>(list);
        model.addAttribute("pageInfo", pageInfo);
        return "WarnMessageQuery";
    }
}
