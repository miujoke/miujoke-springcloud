package com.miujoke.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Description: TODO
 * @Author: miujoke
 * @DateTime: 2021/3/14 15:36
 */
@Configuration
public class ApplicationContentConfig {
    @Bean
    @LoadBalanced  // @LoadBalanced赋予RestTemplate负载均衡能力
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
