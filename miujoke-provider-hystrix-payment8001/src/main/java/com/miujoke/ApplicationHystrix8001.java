package com.miujoke;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: miujoke
 * @DateTime: 2023/5/14 21:23
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class ApplicationHystrix8001 {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationHystrix8001.class, args);
    }
}
