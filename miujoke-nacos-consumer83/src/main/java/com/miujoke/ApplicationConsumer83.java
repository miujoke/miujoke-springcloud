package com.miujoke;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author miujoke
 * @date 2023/5/22 23:53
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ApplicationConsumer83 {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationConsumer83.class, args);
    }
}
