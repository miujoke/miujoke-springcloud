package com.miujoke.auth9001;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.miujoke.auth9001.mapper")
public class Auth9001Application {

    public static void main(String[] args) {
        SpringApplication.run(Auth9001Application.class, args);
    }

}
