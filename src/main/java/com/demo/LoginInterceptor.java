package com.demo;

import com.demo.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request , HttpServletResponse response, Object handler){
       String requestUrl = request.getRequestURI();
        if (requestUrl.equals("/login/login")){
           return true;
       }
        System.out.println(">>>>>>>>>>>>>>>>");
        Cookie[] cookies = request.getCookies();
        if (cookies != null){
            for (Cookie cookie : cookies){
                if (cookie.getName().equals("loginName")){
                    return true;
                }
            }
        }

        return false;
    }
}
