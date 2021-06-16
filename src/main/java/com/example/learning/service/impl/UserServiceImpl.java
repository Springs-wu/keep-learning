package com.example.learning.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.learning.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Override
    public boolean setRedisValue() {
        char[] a = new char[2*1024];
        String s = JSON.toJSONString(a);
        redisTemplate.opsForValue().set("user", s);
        return false;
    }
}
