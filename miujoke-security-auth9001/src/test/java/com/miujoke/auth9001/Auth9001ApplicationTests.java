package com.miujoke.auth9001;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.miujoke.auth9001.entity.User;
import com.miujoke.auth9001.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class Auth9001ApplicationTests {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Test
    void contextLoads() {
        User user = userMapper.selectOne(new QueryWrapper<User>().eq("username", "admin"));
        System.out.println(user);
    }

}
