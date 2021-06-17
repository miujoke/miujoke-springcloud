package com.miujoke.auth2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

/**
 * @Description: TODO
 * @Author: miujoke
 * @DateTime: 2021/6/17 16:09
 */
@Configuration
@EnableAuthorizationServer
public class AuthConfig extends AuthorizationServerConfigurerAdapter {

    // 配置密码加密 springBoot2.X需要配置
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("client")// 客户端 client_id
                .secret(passwordEncoder().encode("secret"))// 客户端 secret
                .authorizedGrantTypes("authorization_code")// 授权类型 ，授权码
                .scopes("app")// 范围
                .redirectUris("http://192.168.44.128/");// 重定向地址
    }
}
