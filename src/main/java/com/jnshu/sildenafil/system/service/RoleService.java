package com.jnshu.sildenafil.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jnshu.sildenafil.common.exception.ServiceException;
import com.jnshu.sildenafil.system.domain.Role;
import com.baomidou.mybatisplus.extension.service.IService;

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
     */
    IPage getRoleList(Integer page, Integer size) throws ServiceException;

    /**根据角色id查询角色
     * @param roleId 角色id
     * @return 单个用户对象
     */
    Role getRoleByRoleId(Long roleId) throws ServiceException;

    /**根据角色id删除角色
     * @param roleId 角色id
     * @return 角色id
     */
    Long deleteRoleByRoleId(Long roleId) throws ServiceException;

    /**增加角色
     * @param role 角色信息
     * @return 保存的角色id
     */
    Long saveRole(Role role) throws ServiceException;

    /**根据角色id修改角色信息
     * @param role 角色信息
     * @return 角色id
     * @throws ServiceException 自定义异常
     */
    Long updateRoleByRoleId (Role role) throws ServiceException;

}
