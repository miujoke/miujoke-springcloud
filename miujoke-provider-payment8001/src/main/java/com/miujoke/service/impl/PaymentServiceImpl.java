package com.miujoke.service.impl;

import com.miujoke.dao.PaymentDao;
import com.miujoke.entities.Payment;
import com.miujoke.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description: TODO
 * @Author: miujoke
 * @DateTime: 2021/3/12 21:59
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @HystrixCommand(fallbackMethod = "getPaymentById_fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),// 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),// 请求总数阈值
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),// 快照时间窗
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),//失败百分比达到多少后跳闸
    })
    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }

    public Payment getPaymentById_fallback(Long id){
        return new Payment();
    }
}
