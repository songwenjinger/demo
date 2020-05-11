package com.example.util;


import org.springframework.http.HttpRequest;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @ author: SongWenjing
 * @ Date 2020/5/11 9:05
 */
public class OperateCookies {
    //获取cookie中ddq对应的value
    public static int getZoneIdCookie(HttpServletRequest httpRequest) {
        Cookie[] cookie = httpRequest.getCookies();
        for (int i = 0; i < cookie.length; i++) {
            Cookie cook = cookie[i];
            if (cook.getName().equalsIgnoreCase("zoneId")) { //获取键 
                return Integer.parseInt(cook.getValue());
            }
        }
        return 0;
    }
}
