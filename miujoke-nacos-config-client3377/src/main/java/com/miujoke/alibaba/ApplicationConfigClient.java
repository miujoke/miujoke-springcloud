package com.miujoke.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author miujoke
 * @date 2023/5/23 22:42
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ApplicationConfigClient {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationConfigClient.class, args);
    }
}
