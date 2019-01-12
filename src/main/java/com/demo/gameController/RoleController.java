package com.demo.gameController;

import com.demo.entity.Role;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role")
public class RoleController extends BaseController{
    @RequestMapping("/getRoleDetails")
    public Role getRoleDetails(){
        Role role = new Role();
        role.setHP(1000000L);
        role.setId(1L);
        role.setLevel(10000);
        role.setMagicAttacks(100000);
        role.setPhysicalDefense(100000);
        role.setName("天启");
        return role;
    }
}
