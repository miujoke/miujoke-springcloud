package com.miujoke.auth2.controller;

import org.springframework.web.bind.annotation.*;

/**
 * @Description: TODO
 * @Author: miujoke
 * @DateTime: 2021/6/18 9:54
 */
@RestController
@RequestMapping("/api")
public class GetValueToClient {

    @GetMapping("/getName/{id}")
    public int resultString(@PathVariable("id") int id){
        System.out.println(id);
        return id;
    }
}
