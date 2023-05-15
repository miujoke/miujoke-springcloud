package com.miujoke.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @Author: miujoke
 * @DateTime: 2023/5/14 21:33
 */
@Service
public class PaymentService {

    /**
     * desc:正常访问返回ok
     *
     * @param id
     * @return java.lang.String
     */
    public String paymentInfo_OK(Integer id){
        return "线程池: " + Thread.currentThread().getName()+" paymentInfo_OK ,id  " + id;
    }

    /**
     * desc:报错访问返回error
     *
     * @param id
     * @return java.lang.String
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_ERRORHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public String paymentInfo_ERROR(Integer id){
        // 报错和超时都走Handler方法
        //int age = 5/0;
        int timeOutNumber = 5;
        try {
            TimeUnit.MILLISECONDS.sleep(13000);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "线程池: " + Thread.currentThread().getName()+" paymentInfo_ERROR ,id  " + id + "耗时" + timeOutNumber + "秒";
    }

    public String paymentInfo_ERRORHandler(Integer id){
        return "人太多了，稍等一会再试";
    }


    // -------------服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),// 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),// 请求总数阈值
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),// 快照时间窗
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),//失败百分比达到多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if (id<0){
            throw new RuntimeException("id不能为负数");
        }
        return "线程池: " + Thread.currentThread().getName()+" paymentCircuitBreaker ,id  " + id;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id){
        return "paymentCircuitBreaker_fallback兜底返回";
    }

}
