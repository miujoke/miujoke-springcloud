package com.miujoke.controller;

import com.miujoke.entities.CommonResult;
import com.miujoke.entities.Payment;
import com.miujoke.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


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

    // 服务发现  通过服务发现来获取注册的信息
    @Resource
    private DiscoveryClient discoveryClient;

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

    @GetMapping("/discovery")
    // 服务发现测试接口
    public Object discovery(){
        // 获取服务列表实例
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            log.info("********element"+element);
        }
        // 通过实例名称获取实例里面的服务
        List<ServiceInstance> instances = discoveryClient.getInstances("miujoke-payment-service");
        for (ServiceInstance instance : instances) {
            log.info(instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri()+"\t"+instance.getServiceId());
        }
        return this.discoveryClient;
    }


}
