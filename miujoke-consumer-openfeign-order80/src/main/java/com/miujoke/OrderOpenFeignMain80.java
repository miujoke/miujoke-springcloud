package com.miujoke;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: miujoke
 * @DateTime: 2023/4/27 21:35
 */
@SpringBootApplication
@EnableFeignClients // 激活与开启
public class OrderOpenFeignMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderOpenFeignMain80.class);
    }
}
