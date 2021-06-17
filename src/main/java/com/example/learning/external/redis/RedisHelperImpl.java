package com.example.learning.external.redis;

import com.example.learning.helper.RedisHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisHelperImpl implements RedisHelper {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 通用set
     * @param key 键
     * @param value 值
     */
    @Override
    public void set(String key, Object value)
    {
        redisTemplate.opsForValue().set(key, value);
    }

    @Override
    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }
}
