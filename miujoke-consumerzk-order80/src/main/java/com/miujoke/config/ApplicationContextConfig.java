package com.miujoke.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Description: TODO
 * @Author: miujoke
 * @DateTime: 2021/3/18 20:55
 */
@Configuration
public class ApplicationContextConfig {

    @LoadBalanced  // 开启负载均衡
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}

