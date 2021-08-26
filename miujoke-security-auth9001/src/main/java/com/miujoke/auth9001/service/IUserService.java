package com.miujoke.auth9001.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.miujoke.auth9001.entity.User;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author miujoke
 * @since 2021-06-18
 */
public interface IUserService extends IService<User> {

    User getUserByName(String username);
}
