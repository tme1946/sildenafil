package com.jnshu.sildenafil.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jnshu.sildenafil.common.exception.ServiceException;
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

    /**条件查询用户列表
     * @param page 页码
     * @param size 每页数量
     * @param roleId 角色id
     * @param userName 用户名
     * @return 列表信息
     */
    IPage getUserList(Integer page,Integer size,Long roleId,String userName);

    /**根据用户名查询用户
     * @param userName 用户名
     * @return 单个用户对象
     */
    User getUserByUserName(String userName);

    /**根据用户名查询roleId
     * @param userName 用户名
     * @return 单个用户对象
     */
    Long getRoleIdByUserName(String userName);

    /**根据用户id查询用户
     * @param userId 用户id
     * @return 单个用户对象
     */
    User getUserByUserId(Long userId) throws ServiceException;

    /**根据用户id删除用户
     * @param userId 用户id
     * @return 用户id
     */
    Long deleteUserByUserId(Long userId) throws ServiceException;

    /**增加用户
     * @param user 用户信息
     * @return 保存的用户id
     */
    Long saveUser(User user) throws ServiceException;

    /**根据用户id修改用户信息
     * @param user 用户信息
     * @return 用户id
     * @throws ServiceException 自定义异常
     */
    Long updateUserByUserId (User user) throws ServiceException;

    /**根据用户id修改用户密码
     * @param userId 用户id
     * @param passwordOld 旧密码
     * @param passwordNew 新密码
     * @return 用户id
     * @throws ServiceException 自定义异常
     */
    Long updateUserPasswordByUserId (String passwordOld,String passwordNew,Long userId) throws ServiceException;

    /**登陆验证密码
     * @param userName 用户登陆名
     * @param password 用户登陆密码
     * @return 登陆的账户id
     * @throws ServiceException 参数异常
     */
    Long userLogin(String userName,String password) throws ServiceException;
}
