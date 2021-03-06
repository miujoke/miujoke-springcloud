package com.miujoke.controller;

import com.miujoke.entities.CommonResult;
import com.miujoke.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Description: TODO 测试80 端口客服端调用8001支付模块
 * @Author: miujoke
 * @DateTime: 2021/3/14 15:34
 */
@RestController
@Slf4j
@RequestMapping("consumer")
public class OrderController {
    // 调用支付模块的地址
//    public static final  String PAYMENT_URL="http://localhost:8001"; //单机版的，
    //微服务版，将地址改为注册中心注册的名字即可，但要在ApplicationContentConfig配置了中加上注解@LoadBalanced赋予RestTemplate负载均衡能力
    public static final  String PAYMENT_URL="http://MIUJOKE-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/payment/create")
    public CommonResult<Payment> create(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
    }

    @GetMapping("/getPaymentById/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/getPaymentById/"+id,CommonResult.class);
    }

}
