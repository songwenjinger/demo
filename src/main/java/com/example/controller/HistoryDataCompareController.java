package com.example.controller;

import com.example.service.HistoryDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

}
