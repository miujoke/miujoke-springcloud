package com.miujoke.auth9001.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @Description: TODO 4、创建OauthPasswordConfig配置注入BCrytpPasswordEncoder对象：
 * @Author: miujoke
 * @DateTime: 2021/6/21 12:44
 */
@Component
public class OauthPasswordConfig {
    /**
    * 必须注入，验证密码需要使用
    */
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
