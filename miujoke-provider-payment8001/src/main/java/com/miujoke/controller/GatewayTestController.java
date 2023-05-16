package com.miujoke.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: miujoke
 * @DateTime: 2023/5/16 22:34
 */
@RestController
@RequestMapping("/eurekaTest")
public class GatewayTestController {

    @GetMapping("/get")
    public String getGateway(){
        return "这是测试gateway的数据";
    }
}
