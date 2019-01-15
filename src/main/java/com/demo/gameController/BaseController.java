package com.demo.gameController;

import com.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@RestController
public class BaseController {
    @Autowired
    HttpServletRequest request;

    public int getUserId(){
//        HttpSession session = request.getSession();
//        User user = (User)session.getAttribute("user");
//        if (ObjectUtils.isEmpty(user)){
//            return 0;
//        }
        return 4;

    }
    public String getUserName(){
        return "刘德华";
//        Cookie[] cookies = request.getCookies();
//        for (Cookie cookie:cookies){
//            if ("loginName".equals(cookie.getName())){
//                return cookie.getValue();
//            }
//        }
//        return null;
    }
}
