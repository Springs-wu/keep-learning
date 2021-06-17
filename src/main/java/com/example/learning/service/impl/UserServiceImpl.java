package com.example.learning.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.learning.helper.RedisHelper;
import com.example.learning.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
}
