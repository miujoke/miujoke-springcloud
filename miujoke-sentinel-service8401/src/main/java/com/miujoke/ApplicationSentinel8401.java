package com.miujoke;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author miujoke
 * @date 2023/5/31 17:13
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ApplicationSentinel8401 {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationSentinel8401.class, args);
    }
}
