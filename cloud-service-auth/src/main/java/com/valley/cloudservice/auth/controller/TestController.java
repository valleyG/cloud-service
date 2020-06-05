package com.valley.cloudservice.auth.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
@RequestMapping("/controller")
public class TestController {
    @Value("${myapp.test}")
    private String value;
    @GetMapping("test")
    public String test(){
        return value;
    }

}
