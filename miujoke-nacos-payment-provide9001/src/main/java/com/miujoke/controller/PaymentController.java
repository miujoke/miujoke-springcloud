package com.miujoke.controller;

import com.miujoke.common.annotation.IdempotentAnnotation;
import com.miujoke.common.annotation.LogExecution;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author miujoke
 * @date 2023/5/22 21:41
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/nacos/{id}")
    @IdempotentAnnotation(key = "ss")
    public String getServerPort(@PathVariable("id") Integer id){
        int i=1/0;
        return "Nacos register serverPort: " + serverPort + "\t id: " + id;
    }
}
