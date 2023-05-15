package com.miujoke.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
