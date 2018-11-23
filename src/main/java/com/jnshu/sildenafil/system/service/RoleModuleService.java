package com.jnshu.sildenafil.system.service;

import com.jnshu.sildenafil.common.exception.ServiceException;
import com.jnshu.sildenafil.system.domain.RoleModule;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author feifei
 * @since 2018-10-31
 */
public interface RoleModuleService extends IService<RoleModule> {

    /**后台根据roleId查询moduleId列表
     * @param roleId 角色id
     * @return moduleId列表
     */
    List<RoleModule> getModuleIdListByRoleId(Long roleId);

    /**增加角色权限
     * @param roleModule 角色模块对象
     * @return 返回记录id
     */
    Long saveRoleModule(RoleModule roleModule) throws ServiceException;

    /**删除角色权限
     * @param roleId 角色id
     * @return 返回记录id
     */
    Long deleteRoleModuleByRoleId(Long roleId) throws ServiceException;

    /**删除角色单个权限
     * @param roleId 角色id
     * @param moduleId 模块id
     * @return 返回记录id
     */
    Long deleteRoleModuleByRMid(Long roleId,Long moduleId) throws ServiceException;

    /**根据用户名删除角色单个权限
     * @param moduleId 角色id
     * @param userName 用户名
     * @return 返回记录id
     */
    Long deleteRoleModuleByUserName(String userName,Long moduleId) throws ServiceException;

    /**更新某个角色的权限
     * @param roleId 角色id
     * @param moduleIdList 权限id集合
     * @return 角色id
     * @throws ServiceException
     */
    Long updateRoleModuleByRoleId(Long roleId,List<Long> moduleIdList) throws ServiceException;

    /**增加某个角色的权限
     * @param roleId 角色id
     * @param moduleIdList 权限id集合
     * @return 角色id
     * @throws ServiceException
     */
    Long saveRoleModuleListByRoleId(Long roleId,ArrayList<Long> moduleIdList) throws ServiceException;

    /**根据userName增加某个角色的单个权限
     * @param userName 用户名
     * @param moduleId 权限id集合
     * @return 角色id
     * @throws ServiceException
     */
    Long saveRoleModuleByUserName(String userName, Long moduleId) throws ServiceException;
}
