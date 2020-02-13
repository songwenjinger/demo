package com.example.controller;

import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    //@GetMapping注解表示以GET方法请求/user/login.do时运行本方法
    @GetMapping("/login.do")
    public String toLogin() {
//        return "login";
        System.out.println("ok");
        return "index";
    }

    //@PostMapping注解表示以POST方法请求/user/login.do时运行本方法
    @PostMapping("/login.do")
    public String login(String userName, String password,
                        HttpSession session, Model model) {
        User user = userService.login(userName, password);
        if (user != null) {
            session.setAttribute("user", user);
            model.addAttribute("user", user);
            return "login";
        }
        return "login";
    }

}
