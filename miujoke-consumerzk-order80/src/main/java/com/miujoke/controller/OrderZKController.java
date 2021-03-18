package com.miujoke.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Description: TODO
 * @Author: miujoke
 * @DateTime: 2021/3/18 20:56
 */
@RestController
@Slf4j
public class OrderZKController {

    public static final String INVOME_URL = "http://miujoke-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/zk")
    public String payment() {
        String result = restTemplate.getForObject(INVOME_URL + "/payment/zk", String.class);
        return result;
    }
}
