package com.miujoke.controller;

import com.miujoke.customrule.LoadBanlancer;
import com.miujoke.entities.CommonResult;
import com.miujoke.entities.Payment;
import com.netflix.loadbalancer.IRule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @Description: TODO 测试80 端口客服端调用8001支付模块
 * @Author: miujoke
 * @DateTime: 2021/3/14 15:34
 */
@RestController
@Slf4j
@RequestMapping("/consumer")
public class OrderController {
    // 调用支付模块的地址
    //public static final  String PAYMENT_URL="http://localhost:8001"; //单机版的，
    //微服务版，将地址改为注册中心注册的名字即可，但要在ApplicationContentConfig配置了中加上注解@LoadBalanced赋予RestTemplate负载均衡能力
    public static final  String PAYMENT_URL="http://MIUJOKE-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private LoadBanlancer loadBanlancer;

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/payment/create")
    public CommonResult<Payment> create(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
    }

    // forObject
    @GetMapping("/getPaymentById/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/getPaymentById/"+id,CommonResult.class);
    }

    // forEntity
    @GetMapping("/getPaymentByIdForEntity/{id}")
    public CommonResult<Payment> getPaymentForEntity(@PathVariable("id") Long id){
        ResponseEntity<CommonResult> forEntity = restTemplate
                .getForEntity(PAYMENT_URL + "/payment/getPaymentById/" + id, CommonResult.class);
        if (forEntity.getStatusCode().is2xxSuccessful()){
            return forEntity.getBody();
        }else {
            return new CommonResult<>(444, "未查询到数据");
        }

    }

    @GetMapping("/getPayment/lb")
    public String getPaymentLB(){
        // 获取MIUJOKE-PAYMENT-SERVICE 名称的所有实例
        List<ServiceInstance> instances = discoveryClient.getInstances("MIUJOKE-PAYMENT-SERVICE");
        if (null == instances || instances.size() == 0){
            return null;
        }
        // 获取提供服务的实例
        ServiceInstance serviceInstance = loadBanlancer.instance(instances);
        URI uri = serviceInstance.getUri();
        return restTemplate.getForObject(uri + "/payment/provider/lb", String.class);
    }

}
