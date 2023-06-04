package com.miujoke.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author miujoke
 * @date 2023/5/31 17:14
 */
@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping("/sentinel/testA")
    public String testA(){
        /*try{
            TimeUnit.MILLISECONDS.sleep(800);
        }catch (Exception e){
            e.printStackTrace();
        }*/
        return "testA for sentinel";
    }

    @GetMapping("/sentinel/testB")
    public String testB(){
        log.info(Thread.currentThread().getName() + "\t" + "......testB");
        return "testB for sentinel";
    }

    @GetMapping("/sentinel/testC")
    public String testC(){
        try{
            TimeUnit.SECONDS.sleep(1);
        }catch (Exception e){
            e.printStackTrace();
        }
        log.info("测试降级RT"+Thread.currentThread().getName() + "\t" + "......testC");
        return "testC for sentinel";
    }
}
