package com.miujoke;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: miujoke
 * @DateTime: 2023/5/18 10:35
 */

@SpringBootApplication
@EnableEurekaClient
public class ApplicationConfig8888 {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationConfig8888.class, args);
    }
}
