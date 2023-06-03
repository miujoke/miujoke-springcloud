package com.miujoke.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author miujoke
 * @date 2023/5/31 17:14
 */
@RestController
public class FlowLimitController {

    @GetMapping("/sentinel/testA")
    public String testA(){
        return "testA for sentinel";
    }

    @GetMapping("/sentinel/testB")
    public String testB(){
        return "testB for sentinel";
    }
}
