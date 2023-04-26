package com.miujoke.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author: miujoke
 * @DateTime: 2023/4/26 0:07
 */
@RestController
public class OrderConsulController {
    @Value("${server.port}")
    private String serverPort;
    @Resource
    private RestTemplate restTemplate;
    public static final  String INVOKE_URL="http://miujoke-providerconsul-payment";

    @GetMapping("/order/consul")
    public String payment() {
        String result = restTemplate.getForObject(INVOKE_URL + "/payment/consul", String.class);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(-8>>>2);
        System.out.println(-8>>2);
        System.out.println(8>>>2);
    }

}
