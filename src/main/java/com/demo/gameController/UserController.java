package com.demo.gameController;

import com.demo.entity.RoleDetails;
import com.demo.entity.User;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController extends BaseController{
    @Autowired
    UserService userService;
    @RequestMapping("/register")
    public String register(User user){
            return userService.register(user);
    }
    @RequestMapping("/getUserDetails")
    public User getUserDetails(){
//        String name = getUserName();
//        User user = userService.getUserByUserName(name);
//        if (user==null){
//            return null;
//        }
        User user = new User();
        user.setId(111111);
        user.setUserName("testName");
        user.setPassword("testPassword");
        return user;
    }
    @RequestMapping("/getRoleDetails")
    public RoleDetails getRoleDetails(){
        RoleDetails roleDetails = new RoleDetails();
        roleDetails.setId(1);
        roleDetails.setAttack(1000);
        roleDetails.setDefense(1000);
        roleDetails.setHp(100000L);
        roleDetails.setName("可口可乐");
        return roleDetails;
    }
}
