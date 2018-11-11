package com.jnshu.sildenafil.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jnshu.sildenafil.system.domain.User;
import com.jnshu.sildenafil.system.mapper.UserDao;
import com.jnshu.sildenafil.system.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author feifei
 * @since 2018-10-31
 */
@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {
    @Autowired(required = false)
    private UserDao userDao;

    /**根据用户名查询用户
     * @param userName 用户名
     * @return 单个用户对象
     */
    @Override
    public User getUserByUserName(String userName){
        log.info("getUserByUserName's args : userName={}",userName);
        if(StringUtils.isNotEmpty(userName)){
            QueryWrapper<User> userQueryWrapper=new QueryWrapper<>();
            userQueryWrapper.eq("user_name",userName);
            User user=userDao.selectOne(userQueryWrapper);
            if(user==null){
                log.error("result for getUserByUserName error;userName is notExit");
                return null;
            }
            log.info("result for getUserByUserName is:{}",user);
            return user;
        }
        log.error("result for getUserByUserName error;userName is null");
        return null;
    }
}
