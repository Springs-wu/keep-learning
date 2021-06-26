package com.example.learning.helper;

/**
 * redis帮助类 方便调用redis的api
 */
public interface RedisHelper {

    void set(String key, Object value);

    Object get(String key);
}
