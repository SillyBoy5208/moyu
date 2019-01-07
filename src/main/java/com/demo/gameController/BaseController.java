package com.demo.gameController;

import com.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@RestController
@EnableAutoConfiguration
public class BaseController {
    @Autowired
    HttpServletRequest request;

    public int getUserId(){
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        if (ObjectUtils.isEmpty(user)){
            return 0;
        }
        return user.getId();

    }
}
