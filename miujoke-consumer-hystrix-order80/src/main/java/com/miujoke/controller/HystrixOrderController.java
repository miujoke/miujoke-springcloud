package com.miujoke.controller;

import com.miujoke.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: miujoke
 * @DateTime: 2023/5/14 22:32
 */
@RequestMapping("/hystrixOrder")
@Slf4j
@RestController
@DefaultProperties(defaultFallback = "paymentInfo_GlobalERRORHandler")
public class HystrixOrderController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        val result = paymentHystrixService.paymentInfo_OK(id);
        return result;
    }

    @GetMapping("/error/{id}")
    /*@HystrixCommand(fallbackMethod = "paymentInfo_ERRORHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })*/
    @HystrixCommand
    public String paymentInfo_ERROR(@PathVariable("id") Integer id){
        val result = paymentHystrixService.paymentInfo_ERROR(id);
        return result;
    }

    // 全局不可以加参数
    public String paymentInfo_GlobalERRORHandler(){

        return "消费者80超时,请稍后再试";
    }
}
