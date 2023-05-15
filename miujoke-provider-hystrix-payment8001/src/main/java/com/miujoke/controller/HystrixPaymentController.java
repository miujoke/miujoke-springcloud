package com.miujoke.controller;

import com.miujoke.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: miujoke
 * @DateTime: 2023/5/14 21:31
 */
@RestController
@RequestMapping("/hystrixPayment")
@Slf4j
public class HystrixPaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        String result = paymentService.paymentInfo_OK(id);
        log.info("*******result: " + result);
        return result;
    }

    @GetMapping("/error/{id}")
    public String paymentInfo_ERROR(@PathVariable("id") Integer id){
        int i=10/1;
        String result = paymentService.paymentInfo_ERROR(id);
        log.info("*******result: " + result);
        return result;
    }
}
