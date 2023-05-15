package com.miujoke;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;


/**
 * @Author: miujoke
 * @DateTime: 2023/5/14 22:30
 */
@SpringBootApplication
@EnableFeignClients
@EnableCircuitBreaker
public class ApplicationHystrixOrder80 {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationHystrixOrder80.class, args);
    }
}
