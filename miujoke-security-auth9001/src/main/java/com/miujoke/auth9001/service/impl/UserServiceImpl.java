package com.miujoke.auth9001.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.miujoke.auth9001.entity.User;
import com.miujoke.auth9001.mapper.UserMapper;
import com.miujoke.auth9001.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author miujoke
 * @since 2021-06-18
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public User getUserByName(String username) {
        User user = userMapper.selectOne(new QueryWrapper<User>().eq("username", username));
        return user;
    }
}
