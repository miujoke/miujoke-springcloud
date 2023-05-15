package com.miujoke.service;

import org.springframework.stereotype.Component;

/**
 * @Author: miujoke
 * @DateTime: 2023/5/15 10:00
 */
@Component
public class PaymentHystrixFallBackService implements PaymentHystrixService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "实现类ok异常";
    }

    @Override
    public String paymentInfo_ERROR(Integer id) {
        return "实现类error异常";
    }
}
