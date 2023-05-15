package com.miujoke.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: miujoke
 * @DateTime: 2023/5/14 22:35
 */
@Component
@FeignClient(value = "PROVIDER-HYSTRIX-PAYMENT8001", fallback = PaymentHystrixFallBackService.class)
public interface PaymentHystrixService {

    @GetMapping("/hystrixPayment/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id);

    @GetMapping("/hystrixPayment/error/{id}")
    public String paymentInfo_ERROR(@PathVariable("id") Integer id);
}
