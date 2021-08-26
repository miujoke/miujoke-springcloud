package com.miujoke.auth9001.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.miujoke.auth9001.entity.Permission;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author miujoke
 * @since 2021-06-18
 */
public interface PermissionMapper extends BaseMapper<Permission> {

    List<Permission> selectByUserId(long UserId);
}

