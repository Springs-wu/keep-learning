package com.example.learning.controller;

import com.example.learning.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class UserServiceController {

    @Autowired
    private UserService userService;

    @RequestMapping("/setRedisValue")
    @ResponseBody()
    boolean setRedisValue(){
        return userService.setRedisValue();
    }
}
