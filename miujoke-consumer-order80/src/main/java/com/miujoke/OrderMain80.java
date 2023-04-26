package com.miujoke;

import com.ribbon.rule.OrderRibbonRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @Description: TODO 客服端
 * @Author: miujoke
 * @DateTime: 2021/3/14 15:32
 */
@SpringBootApplication
@EnableEurekaClient
//@RibbonClient(name="MIUJOKE-PAYMENT-SERVICE", configuration = OrderRibbonRule.class) //引入自己定义的负载均衡规则
public class OrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class, args);
    }
}
