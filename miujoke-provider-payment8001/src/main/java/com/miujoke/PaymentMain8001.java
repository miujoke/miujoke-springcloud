package com.miujoke;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Description: TODO
 * @Author: miujoke
 * @DateTime: 2021/3/12 21:18
 */
@SpringBootApplication
@MapperScan("com.miujoke.dao")
@EnableEurekaClient  // 开启Eureka客服端
public class PaymentMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8001.class, args);
    }
}
