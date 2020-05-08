package com.example.controller;

import com.example.entity.RegionMes;
import com.example.service.RegionMesOperateService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ author: SongWenjing
 * @ Date 2020/5/7 20:08
 */
@Controller
@RequestMapping("/modifyZoneMessage")
public class ModifyZoneMessageController {
    @Autowired
    RegionMesOperateService regionMesOperateService;

    @GetMapping(value = "/queryAll.do")
    public String queryAll(Model model, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) {
        PageHelper.startPage(pageNum, 8);
        List<RegionMes> list = regionMesOperateService.queryAll();
        PageInfo<RegionMes> pageInfo = new PageInfo<RegionMes>(list);
        model.addAttribute("pageInfo", pageInfo);
        return "ModifyZoneMessage";
    }

    @GetMapping(value = "/jumpUpdate.do")
    public String jumpUpdate() {
        return "ModifyZoneMessageUpdate";
    }

    @PostMapping(value = "/updateStatus.do")
    @ResponseBody
    public Integer updateStatus(Integer id, Integer status) {
        return regionMesOperateService.updateStatus(id, status);
    }

    @PostMapping(value = "/updateRegionMes.do")
    @ResponseBody
    public Integer updateRegionMes(Integer id, String zoneName, String brief, String phone, String email) {
        return regionMesOperateService.updateRegion(id, zoneName, brief, phone, email);
    }


}
