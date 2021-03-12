package com.miujoke;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description: TODO
 * @Author: miujoke
 * @DateTime: 2021/3/12 21:18
 */
@SpringBootApplication
@MapperScan("com.miujoke.dao")
public class PaymentMain8001 {
    public static void main(String[] args) {
       SpringApplication.run(PaymentMain8001.class,args);
    }
}
