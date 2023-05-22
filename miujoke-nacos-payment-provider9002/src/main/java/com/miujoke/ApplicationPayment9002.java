package com.miujoke;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 * @author miujoke
 * @date 2023/5/22 21:42
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ApplicationPayment9002 {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationPayment9002.class, args);
    }
}
