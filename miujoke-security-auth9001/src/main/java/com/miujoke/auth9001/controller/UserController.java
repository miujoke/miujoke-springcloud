package com.miujoke.auth9001.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author miujoke
 * @since 2021-06-18
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/pwd")
    public void getPassword(@RequestParam String password){
        System.out.println(bCryptPasswordEncoder.encode(password));
    }

}
