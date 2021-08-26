package com.miujoke.auth9001.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.miujoke.auth9001.entity.Permission;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author miujoke
 * @since 2021-06-18
 */
public interface IPermissionService extends IService<Permission> {

    List<Permission> getByUserId(long userId);
}
