package com.jnshu.sildenafil.system.service.impl;

import com.jnshu.sildenafil.system.domain.User;
import com.jnshu.sildenafil.system.mapper.UserDao;
import com.jnshu.sildenafil.system.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Taimur
 * @since 2018-10-31
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

}
