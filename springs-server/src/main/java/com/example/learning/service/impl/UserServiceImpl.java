package com.example.learning.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.learning.entity.User;
import com.example.learning.helper.RedisHelper;
import com.example.learning.service.UserService;
import org.openjdk.jol.info.ClassLayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RedisHelper redisHelper;

    @Override
    public boolean setRedisValue() {
        char[] a = new char[2*1024];
        String s = JSON.toJSONString(a);
        redisHelper.set("user", s);
        return false;
    }

    public static void main(String[] args) {
        User user = new User();
        User[] users = new User[10];
        System.out.println(ClassLayout.parseInstance(user).toPrintable());
        System.out.println(ClassLayout.parseInstance(users).toPrintable());
    }
}
