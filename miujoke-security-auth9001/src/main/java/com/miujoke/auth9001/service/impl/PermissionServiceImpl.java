package com.miujoke.auth9001.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.miujoke.auth9001.entity.Permission;
import com.miujoke.auth9001.mapper.PermissionMapper;
import com.miujoke.auth9001.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author miujoke
 * @since 2021-06-18
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {

    @Autowired
    private PermissionMapper permissionMapper;
    @Override
    public List<Permission> getByUserId(long userId) {
        return permissionMapper.selectByUserId(userId);
    }
}
