package com.miujoke.config;

import com.miujoke.mqListener.ConsumerListener;
import com.miujoke.mqListener.handler.impl.ConsumerHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: duxin
 * @DateTime: 2023/3/10 10:41
 */
@Configuration
public class MqBusinessConfig {
    @Autowired
    private ConsumerHandler consumerHandler;

    @Bean
    ConsumerListener consumerListener(){
        ConsumerListener consumerListener = new ConsumerListener();
        // msgKey ,发消息哪里传来的key
        consumerListener.registerMsgHandler("msgKeyBySendService", consumerHandler);
        return consumerListener;
    }
}
