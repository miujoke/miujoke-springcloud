package com.miujoke.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * @Author: miujoke
 * @DateTime: 2023/5/17 0:37
 * 自定义全局日志过滤器
 */
@Component
@Slf4j
public class CustomGlobalLogFilter implements GlobalFilter, Ordered {
    // 过滤判断用户是否带上uname
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("********come in LogFilter: " + new Date());
        String uname = exchange.getRequest().getQueryParams().getFirst("uname");
        if (null == uname){
            log.info("********用户名为空，非法用户");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            // 非法用户
            return exchange.getResponse().setComplete();
        }
        // 合法用户下一个过滤器
        return chain.filter(exchange);
    }

    // 加载这个过滤器优先级Integer
    @Override
    public int getOrder() {
        return 0;
    }
}
