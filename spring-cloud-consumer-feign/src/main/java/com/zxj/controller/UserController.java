package com.zxj.controller;

import com.zxj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zxj
 * @create 2018/8/15 14:48
 */
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/port")
    public String sayHi(){
        return userService.showPort();
    }

}
