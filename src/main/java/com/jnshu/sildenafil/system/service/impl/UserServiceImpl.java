package com.jnshu.sildenafil.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jnshu.sildenafil.common.exception.ServiceException;
import com.jnshu.sildenafil.common.userName.UserNameUtil;
import com.jnshu.sildenafil.common.validation.UserLogin;
import com.jnshu.sildenafil.common.validation.UserSave;
import com.jnshu.sildenafil.common.validation.UserUpdate;
import com.jnshu.sildenafil.system.domain.Article;
import com.jnshu.sildenafil.system.domain.Role;
import com.jnshu.sildenafil.system.domain.User;
import com.jnshu.sildenafil.system.mapper.RoleDao;
import com.jnshu.sildenafil.system.mapper.UserDao;
import com.jnshu.sildenafil.system.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jnshu.sildenafil.util.MyPage;
import com.jnshu.sildenafil.util.ValidationUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

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
    @Autowired(required = false)
    private RoleDao roleDao;

    /**
     * 条件查询用户列表
     *
     * @param page     页码
     * @param size     每页数量
     * @param roleId   角色id
     * @param userName 用户名
     * @return 列表信息
     */
    @Override
    public IPage getUserList(Integer page, Integer size, Long roleId, String userName) {
        log.debug("args for getUserList: page={}&size={}&roleId={}&userName={}", page, size, roleId, userName);
        //调整page和size默认值--
        page = null == page || page <= 1 ? 1 : page;
        size = null == size || size <= 1 || size > 20 ? 10 : size;
        IPage<User> pageQuery = new MyPage<User>(page, size).setDesc("update_at");
        //构建条件查询语句
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .select("id","user_name","create_at","create_by","update_at","update_by","role_id")
                .eq(null != roleId, "role_id", roleId)
                .like(StringUtils.isNotBlank(userName), "user_name", userName);
        IPage<User> userIPage = userDao.selectPage(pageQuery, queryWrapper);
        if (userIPage.getRecords().size() > 0) {
            //存在数据;根据roleId查询roleName进行拼接
//            List roleNamelist=userIPage.getRecords().stream()
//                    .map(rd -> roleDao.selectById(rd.getRoleId()).getRoleName()).collect(Collectors.toList());
//            List allPage=userIPage.getRecords();
            log.info("result for getUserList's size is {}", userIPage.getRecords().size());
            return userIPage;
        } else {
            log.error("result for getUserList error :***reason is list null***");
            return null;
        }
    }

    /**
     * 根据用户名查询用户
     *
     * @param userName 用户名
     * @return 单个用户对象
     */
    @Override
    public User getUserByUserName(String userName) {
        log.debug("args for getUserByUserName: userName={}", userName);
        if (StringUtils.isNotEmpty(userName)) {
            QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
            userQueryWrapper
                    .select("id","user_name","create_at","create_by","update_at","update_by","role_id")
                    .eq("user_name", userName);
            User user = userDao.selectOne(userQueryWrapper);
            if (user == null) {
                log.error("result for getUserByUserName error;userName is notExit");
                return null;
            }
            log.info("result for getUserByUserName is:{}", user);
            return user;
        }
        log.error("result for getUserByUserName error;userName is null");
        return null;
    }

    /**
     * 根据用户名查询roleId
     *
     * @param userName 用户名
     * @return 单个用户对象
     */
    @Override
    public Long getRoleIdByUserName(String userName) {
        log.debug("args for getRoleIdByUserName: userName={}", userName);
        if (StringUtils.isNotBlank(userName)) {
            QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
            userQueryWrapper.select("id").eq("user_name", userName);
            User user = userDao.selectOne(userQueryWrapper);
            if (user == null) {
                log.error("result for getRoleIdByUserName error;userName is notExit");
                return null;
            }
            log.info("result for getRoleIdByUserName is:{}", user.getRoleId());
            return user.getRoleId();
        }
        log.error("result for getRoleIdByUserName error;userName is null");
        return null;
    }

    /**
     * 根据用户id查询用户
     *
     * @param userId 用户id
     * @return 单个用户对象
     */
    @Override
    public User getUserByUserId(Long userId) throws ServiceException {
        log.debug("args for getUserByUserId: userId={}", userId);
        if (null == userId) {
            log.error("result for getUserByUserId error;userId is null");
            throw new ServiceException("getUserByUserId error;args null");
        }
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper
                .select("id","user_name","create_at","create_by","update_at","update_by","role_id")
                .eq("id", userId);
        User user = userDao.selectOne(userQueryWrapper);
        if (user == null) {
            log.error("result for getUserByUserId error;userId is notExit");
            return null;
        }
        log.info("result for getUserByUserId is:{}", user);
        return user;
    }

    /**
     * 根据用户id删除用户
     *
     * @param userId 用户id
     * @return 删除的用户id
     */
    @Override
    public Long deleteUserByUserId(Long userId) throws ServiceException {
        log.info("args for deleteUserByUserId: userId={}", userId);
        if (null == userId) {
            log.error("result for deleteUserByUserId error;userId is null");
            throw new ServiceException("deleteUserByUserId error;args null");
        }
        int i = userDao.deleteById(userId);
        if (i == 0) {
            log.error("result for deleteUserByUserId error;userId is notExit");
            return null;
        }
        log.info("result for deleteUserByUserId's id:{}", userId);
        return userId;
    }

    /**
     * security默认加密方式
     *
     * @return 加密类
     */
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 增加用户
     *
     * @param user 用户信息
     * @return 保存的用户id
     */
    @Override
    public Long saveUser(User user) throws ServiceException {
        log.info("args for saveUser: user={}", user);
        if (null == user) {
            log.error("result for saveUser error;user is null");
            throw new ServiceException("saveUser error;args null");
        }
        //校验结果抛出serviceException
        ValidationUtils.validate(user, UserSave.class);
        user.setCreateAt(System.currentTimeMillis());
        user.setCreateBy("admin");
        user.setUpdateAt(System.currentTimeMillis());
        user.setUpdateBy("admin");
        //将密码加密，使用security框架自带的加密
        String passwordEncrypt = this.bCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(passwordEncrypt);
        int i = userDao.insert(user);
        if (i == 0) {
            log.error("result for saveUser error;save error");
            return null;
        }
        log.info("result for saveUser's id:{}", user.getId());
        return user.getId();
    }

    /**
     * 根据用户id修改用户信息
     *
     * @param user 用户信息
     * @return 用户id
     */
    @Override
    public Long updateUserByUserId(User user) throws ServiceException {
        log.info("args for updateUserByUserId: user={}", user);
        if (null == user) {
            log.error("result for getUserByUserId error;user is null");
            throw new ServiceException("updateUserByUserId error;args null");
        }
        //校验结果抛出serviceException
        ValidationUtils.validate(user, UserUpdate.class);
        user.setUpdateAt(System.currentTimeMillis());
        user.setUpdateBy("admin");
        int i = userDao.updateById(user);
        if (i == 0) {
            log.error("result for updateUserByUserId error;userId is notExit");
            return null;
        }
        log.info("result for updateUserByUserId's id:{}", user.getId());
        return user.getId();
    }

    /**
     * 根据用户id修改用户密码
     *
     * @param userId      用户id
     * @param passwordOld 旧密码
     * @param passwordNew 新密码
     * @return 用户id
     * @throws ServiceException 自定义异常
     */
    @Override
    public Long updateUserPasswordByUserId(String passwordOld, String passwordNew, Long userId) throws ServiceException {
        log.info("args for updateUserPasswordByUserId: passwordOld={}&passwordNew={}&userId={}", passwordOld, passwordNew, userId);
        if (null != passwordOld && null != passwordNew && null != userId) {
            User user = userDao.selectById(userId);
            //user账户不存在
            if (user == null) {
                log.error("result for updateUserPasswordByUserId error;userId is notExit");
                throw new ServiceException("userId is notExit");
            }
            //密码相等
            if (this.bCryptPasswordEncoder().matches(passwordOld,user.getPassword())) {
                //将密码加密，使用security框架自带的加密
                String passwordEncrypt = this.bCryptPasswordEncoder().encode(passwordNew);
                user.setPassword(passwordEncrypt);
                user.setUpdateAt(System.currentTimeMillis());
                user.setUpdateBy("admin");
                userDao.updateById(user);
                log.info("result for updateUserPasswordByUserId's id:{}", user.getId());
                return userId;
            }
            //密码不想等
            log.error("result for updateUserPasswordByUserId error;password error");
            return null;
        }
        //参数有null值
        log.error("result for updateUserPasswordByUserId error;args has null");
        return null;
    }


    /**
     * 登陆验证密码
     *
     * @param userName 用户登陆名
     * @param password 用户登陆密码
     * @return 登陆的账户id
     * @throws ServiceException 参数异常
     */
    @Override
    public Long userLogin(String userName, String password) throws ServiceException {
        log.info("args for userLogin: userName=[{}]&password=[{}]", userName, password);
        if (null == userName || null == password) {
            log.error("result for userLogin error;args null");
            throw new ServiceException("userLogin error;args null");
        }
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        //校验结果抛出serviceException
        ValidationUtils.validate(user, UserLogin.class);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name", userName);
        User user1 = userDao.selectOne(queryWrapper);
        if (null != user1) {
            String passwordFinal = user1.getPassword();
            //加密对比
            if (this.bCryptPasswordEncoder().matches(password, passwordFinal)) {
                //密码正确
                log.info("result for userLogin success;userId is [{}]", user1.getId());
                return user1.getId();
            } else {
                log.error("result for userLogin error;password error");
                return null;
            }
        }
        log.error("result for userLogin error;user not exist");
        return null;
    }
}
