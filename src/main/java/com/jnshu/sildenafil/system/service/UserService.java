package com.jnshu.sildenafil.system.service;

import com.jnshu.sildenafil.system.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Taimur
 * @since 2018-10-31
 */
public interface UserService extends IService<User> {

    /**根据用户名查询用户
     * @param userName 用户名
     * @return 单个用户对象
     */
    User getUserByUserName(String userName);
}
