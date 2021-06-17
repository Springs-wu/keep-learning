package com.example.learning.service;

import com.example.learning.BaseApplicationTest;
import com.example.learning.helper.RedisHelper;
import lombok.Data;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImplTest extends BaseApplicationTest {

    @Autowired
    private RedisHelper redisHelper;

    @Test
    public void setStringValue() {
        redisHelper.set("user1", "springs");
        System.out.println(redisHelper.get("user1"));
    }

    @Test
    public void setObjectValue() {
        User user = new User();
        user.setName("springs");
        user.setAge(18);
        redisHelper.set("user2", user);
        System.out.println(redisHelper.get("user2"));
    }

    @Data
    private static class User
    {
        private String name;

        private int age;
    }
}