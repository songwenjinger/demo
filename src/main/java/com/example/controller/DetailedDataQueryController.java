package com.example.controller;

import com.example.entity.RegionData;
import com.example.service.DetailedDataQueryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping(value = "/queryAll.do")
    public String queryAll(Model model, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) {
        PageHelper.startPage(pageNum, 5);
        List<RegionData> list = detailedDataQueryService.queryAll();
        PageInfo<RegionData> pageInfo = new PageInfo<RegionData>(list);
        model.addAttribute("pageInfo", pageInfo);
        return "DetailedDataQuery";
    }

}
