package com.example.controller;

import com.example.service.TextMessagingSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.mail.MessagingException;

/**
 * @ author: SongWenjing
 * @ Date 2020/5/5 9:49
 */
@Controller
@RequestMapping("/textMessagingSend")
public class TextMessagingSendController {
    @Autowired
    TextMessagingSendService textMessagingSendService;

    @GetMapping("/jumpTextMessagingSend.do")
    public String jumpTextMessagingSend() {
        return "TextMessagingSend";
    }

    @PostMapping("/sendMail.do")
    @ResponseBody
    public boolean sendMail(String sendMail, String subject, String text) throws MessagingException {
        System.out.println("ok");
        return textMessagingSendService.sendMail(sendMail, subject, text);
    }
}
