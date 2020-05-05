package com.example.controller;

import com.example.entity.TextMessaging;
import com.example.service.TextMessagingQueryService;
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
 * @ Date 2020/5/4 16:44
 */
@Controller
@RequestMapping("/textMessagingQuery")
public class TextMessagingQueryController {
    @Autowired
    TextMessagingQueryService textMessagingQueryService;

    @GetMapping(value = "/queryAll.do")
    public String queryAll(Model model, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) {
        PageHelper.startPage(pageNum, 8);
        List<TextMessaging> list = textMessagingQueryService.queryAll();
        PageInfo<TextMessaging> pageInfo = new PageInfo<TextMessaging>(list);
        model.addAttribute("pageInfo", pageInfo);
        return "TextMessagingQuery";
    }


    @PostMapping(value = "/queryByCondition.do")
    public String queryByCondition(Model model, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum,
                                   Integer zoneId, String startTime, String endTime) throws ParseException {
        List<TextMessaging> list;
        if (startTime == null || startTime.equals("")) {
            PageHelper.startPage(pageNum, 8);
            list = textMessagingQueryService.queryAll();
        } else {
            PageHelper.startPage(pageNum, 8);
            list = textMessagingQueryService.queryByCondition(zoneId, startTime, endTime);
        }
        PageInfo<TextMessaging> pageInfo = new PageInfo<TextMessaging>(list);
        model.addAttribute("pageInfo", pageInfo);
        return "TextMessagingQuery";
    }
}
