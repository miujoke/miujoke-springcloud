package com.miujoke;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author miujoke
 * @date 2023/5/21 23:13
 */

@SpringBootApplication
@EnableEurekaClient
public class StreamApplicationConsumer8802 {
    public static void main(String[] args) {
        SpringApplication.run(StreamApplicationConsumer8802.class, args);
    }
}
