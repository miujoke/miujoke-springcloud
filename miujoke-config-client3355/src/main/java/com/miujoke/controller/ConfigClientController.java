package com.miujoke.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author miujoke
 * @date 2023/5/20 0:32
 */
@RestController
@RefreshScope // 动态刷新配置 需要请求一下 curl -X POST "http://localhost:3355/actuator/refresh"
public class ConfigClientController {
    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/configInfo")
    public String getConfigInfo(){
        return configInfo;
    }
}
