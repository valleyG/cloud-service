package com.valley.cloudservice.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
*
* @author:zhuhongmin
* @date:2020/6/9
* @description:
**/
@RestController
@RefreshScope
@RequestMapping("/controller")
public class UserController {
    @Value("${myapp.test}")
    private String value;

    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @GetMapping("test")
    public String test(){
        ValueOperations<String, String> stringValueOperations = redisTemplate.opsForValue();
        stringValueOperations.set(value,"test");

        return stringValueOperations.get(value);
    }




}
