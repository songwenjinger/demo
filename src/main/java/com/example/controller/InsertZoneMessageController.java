package com.example.controller;

import com.example.entity.RegionMes;
import com.example.service.RegionMesOperateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ author: SongWenjing
 * @ Date 2020/5/7 20:33
 */
@Controller
@RequestMapping("/insertZoneMessage")
public class InsertZoneMessageController {
    @Autowired
    RegionMesOperateService regionMesOperateService;

    @GetMapping(value = "/jumpInsertZoneMessage.do")
    public String jumpInsertZoneMessage() {
        return "InsertZoneMessage";
    }

    @PostMapping(value = "/insertZoneMessage.do")
    @ResponseBody
    public Integer InsertZoneMessage(String zoneName, String brief, String phone, String email) {
        return regionMesOperateService.addRegionMes(zoneName, brief, phone, email);
    }
}
