package com.jnshu.sildenafil.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jnshu.sildenafil.common.exception.ServiceException;
import com.jnshu.sildenafil.system.domain.Role;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jnshu.sildenafil.system.domain.User;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Taimur
 * @since 2018-10-31
 */
public interface RoleService extends IService<Role> {

    /**查询角色列表
     * @param page 页码
     * @param size 每页数量
     * @return 列表信息
     * @throws ServiceException 自定义异常
     */
    IPage getRoleList(Integer page, Integer size) throws ServiceException;

    /**根据角色id查询角色
     * @param roleId 角色id
     * @return 单个用户对象
     * @throws ServiceException 自定义异常
     */
    Role getRoleByRoleId(Long roleId) throws ServiceException;

    /**根据用户List查询角色List
     * @param userIPage 用户page类
     * @return 单个用户对象
     * @throws ServiceException 自定义异常
     */
    List<Role> getRoleListByUserList(IPage<User> userIPage) throws ServiceException;

    /**根据角色id删除角色
     * @param roleId 角色id
     * @return 角色id
     * @throws ServiceException 自定义异常
     */
    Long deleteRoleByRoleId(Long roleId) throws ServiceException;

    /**增加角色
     * @param role 角色信息
     * @return 保存的角色id
     * @throws ServiceException 自定义异常
     */
    Long saveRole(Role role) throws ServiceException;

    /**根据角色id修改角色信息
     * @param role 角色信息
     * @return 角色id
     * @throws ServiceException 自定义异常
     */
    Long updateRoleByRoleId (Role role) throws ServiceException;

}
