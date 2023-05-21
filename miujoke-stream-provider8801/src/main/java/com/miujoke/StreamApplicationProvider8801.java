package com.miujoke;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author miujoke
 * @date 2023/5/21 22:45
 */
@SpringBootApplication
@EnableEurekaClient
public class StreamApplicationProvider8801 {
    public static void main(String[] args) {
        SpringApplication.run(StreamApplicationProvider8801.class, args);
    }
}
