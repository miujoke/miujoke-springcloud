package com.miujoke.service;

import com.miujoke.entities.CommonResult;
import com.miujoke.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: miujoke
 * @DateTime: 2023/4/27 21:39
 */
@Component
@FeignClient(value = "MIUJOKE-PAYMENT-SERVICE")
public interface OpenFeignPaymentService {

    @GetMapping("/payment/getPaymentById/{id}") // Payment8001,8002服务提供者对外提供的地址
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id);

    @GetMapping("/payment/timeOutTest") // Payment8001,8002服务提供者对外提供的地址
    public String timeOutTest();
}
