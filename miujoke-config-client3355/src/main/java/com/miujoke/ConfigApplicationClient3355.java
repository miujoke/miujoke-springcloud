package com.miujoke;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author miujoke
 * @date 2023/5/20 0:30
 */
@SpringBootApplication
@EnableEurekaClient
public class ConfigApplicationClient3355 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigApplicationClient3355.class, args);
    }
}
