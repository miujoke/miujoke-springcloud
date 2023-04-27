package com.miujoke.controller;

import com.miujoke.entities.CommonResult;
import com.miujoke.entities.Payment;
import com.miujoke.service.OpenFeignPaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: miujoke
 * @DateTime: 2023/4/27 21:44
 */
@RestController
@Slf4j
@RequestMapping("/consumer")
public class OpenFeignConsumerController {
    @Resource
    private OpenFeignPaymentService openFeignPaymentService;

    @GetMapping("/getPaymentById/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return openFeignPaymentService.getPayment(id);
    }

    @GetMapping("/timeOutTest")
    public String timeOutTest(){
        return openFeignPaymentService.timeOutTest();
    }
}
