package com.miujoke;

import com.miujoke.entities.CommonResult;
import com.miujoke.entities.Payment;
import com.miujoke.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;


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

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("*****插入结果" + result);
        if (result > 0) {
            return new CommonResult(200, "插入成功" + serverPort, result);
        } else {
            return new CommonResult(444, "插入失败" + serverPort);
        }
    }

    @GetMapping("/getPaymentById/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment result = paymentService.getPaymentById(id);
        log.info("*****插入结果" + result + "\t" + "哈哈哈");
        if (result != null) {
            return new CommonResult(200, "查询成功了222" + serverPort, result);
        } else {
            return new CommonResult(444, "没有对应记录" + serverPort, null);
        }
    }

    // 获取当前轮询到的服务端口号
    @GetMapping("/provider/lb")
    public String getPaymentLB(){
        return serverPort;
    }

    @GetMapping("/timeOutTest")
    public String timeOutTest(){
        try{
            // 睡眠3秒，openFeign一般默认等待1秒钟
            TimeUnit.SECONDS.sleep(3);
        }catch (Exception e){
            log.info("超时了", e);
        }
        return serverPort;
    }
}
