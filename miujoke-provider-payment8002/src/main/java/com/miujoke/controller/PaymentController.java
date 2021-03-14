package com.miujoke.controller;

import com.miujoke.entities.CommonResult;
import com.miujoke.entities.Payment;
import com.miujoke.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * @Description: TODO
 * @Author: miujoke
 * @DateTime: 2021/3/12 22:01
 */
@RestController
@RequestMapping("payment")
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;


    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("*****插入结果" + result);
        if (result > 0) {
            return new CommonResult(200, "插入成功", result);
        } else {
            return new CommonResult(444, "插入失败");
        }
    }

    @GetMapping("/getPaymentById/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment result = paymentService.getPaymentById(id);
        log.info("*****插入结果" + result+"\t"+"哈哈哈");
        if (result != null) {
            return new CommonResult(200, "查询成功了222", result);
        } else {
            return new CommonResult(444, "没有对应记录", null);
        }
    }


}
