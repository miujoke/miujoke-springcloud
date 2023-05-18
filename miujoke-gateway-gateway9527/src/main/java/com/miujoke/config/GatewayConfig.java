package com.miujoke.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: miujoke
 * @DateTime: 2023/5/16 23:39
 * 路由配置使用javabean的方式注入
 */
@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        return routeLocatorBuilder.routes()
                .route("path_eurekaTest_route",
                p -> p.path("/eurekaTest/**").uri("localhost:8001")).build();
    }

}
