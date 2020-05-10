package com.example.controller;

import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    //@GetMapping注解表示以GET方法请求/user/login.do时运行本方法
 /*   @GetMapping("/login.do")
    public String toLogin() {
        System.out.println("ok");
        return "adminMainShow";
    }*/

    @GetMapping("/logout.do")
    public String logout() {
        return "index";
    }

    @GetMapping("/jumpUpdatePassword")
    public String jumpUpdatePassword() {
        return "UpdatePassword";
    }

    @GetMapping("/adminMainShow.do")
    public String adminMainShow() {
        return "adminMainShow";
    }

    @RequestMapping("/hi")
    public ModelAndView sayHello() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("key", 12345);
        return modelAndView;

    }

    //@PostMapping注解表示以POST方法请求/user/login.do时运行本方法
    @PostMapping("/login.do")
    public String login(@RequestParam String userPhone, @RequestParam String password) {
        User user = userService.login(userPhone, password);
        if (user != null) {
            return user.getIdentity() == 1 ? "adminMainShow" : "userMainShow";
        } else {
            return "index";
        }
    }

    @PostMapping(value = "/updatePassword.do")
    @ResponseBody
    public int updatePassword(String originPassword, String password, String userPhone) {
        return userService.updatePassword(originPassword, password, userPhone);
    }
}
