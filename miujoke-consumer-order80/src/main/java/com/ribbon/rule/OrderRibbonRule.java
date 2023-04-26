package com.ribbon.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: miujoke
 * @DateTime: 2023/4/26 22:37
 * 切换Ribbon规则配置
 */
@Configuration
public class OrderRibbonRule {

    @Bean
    public IRule getOrderRibbonRule(){
        // 默认轮询，此处配置-随机 使用默认的就在启动类中加上@RibbonClient(name="MIUJOKE-PAYMENT-SERVICE", configuration = OrderRibbonRule.class)
        return new RandomRule();
    }
}
