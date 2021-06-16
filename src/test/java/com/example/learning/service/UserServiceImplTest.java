package com.example.learning.service;

import com.alibaba.fastjson.JSON;
import com.example.learning.BaseApplicationTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

public class UserServiceImplTest extends BaseApplicationTest {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    public void setRedisValue() {
        char[] a = new char[2*1024];
        String s = JSON.toJSONString(a);
        redisTemplate.opsForValue().set("user", s);
    }

    private class User
    {
        private String name;

        private int age;
    }
}