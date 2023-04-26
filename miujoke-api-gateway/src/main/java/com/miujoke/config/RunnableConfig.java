package com.miujoke.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * @Author: duxin
 * @DateTime: 2023/3/9 14:25
 */
@Configuration
public class RunnableConfig implements ApplicationContextAware {

    @Autowired
    private ApplicationContext APPLICATION_CONTEXT;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.APPLICATION_CONTEXT = applicationContext;
    }

    //@Bean
    public MessagerHandler userRights(){
        Map<String, MessagerHandler> beansOfType = APPLICATION_CONTEXT.getBeansOfType(MessagerHandler.class);
        return beansOfType.get("s");
    }
}
