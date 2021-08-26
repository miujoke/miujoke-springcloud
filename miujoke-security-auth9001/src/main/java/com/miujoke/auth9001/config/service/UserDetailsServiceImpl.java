package com.miujoke.auth9001.config.service;

import com.miujoke.auth9001.entity.Permission;
import com.miujoke.auth9001.entity.User;
import com.miujoke.auth9001.service.IPermissionService;
import com.miujoke.auth9001.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: TODO
 * 这里将内存换到数据库，使用userDetailsService，
 * 因为，我们需要注入UserDetailsService,创建UserDetailsServiceImpl文件
 *
 * @Author: miujoke
 * @DateTime: 2021/6/21 11:20
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private IUserService userService;

    @Autowired
    private IPermissionService permissionService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getUserByName(username);
        // 验证账户为username的用户是否存在
        if(null == user){
            throw new UsernameNotFoundException("username:"+username+"不存在");
        }
        List<GrantedAuthority> authorities=new ArrayList<>();
        // 获取用户权限
        List<Permission> permissions = permissionService.getByUserId((user.getId()));
        // 设置用户权限
        permissions.forEach(permission ->{
            authorities.add(new SimpleGrantedAuthority(permission.getEname()));
        });
        // 返回用户认证
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),authorities);
    }
}
