package com.jnshu.sildenafil.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jnshu.sildenafil.common.exception.ServiceException;
import com.jnshu.sildenafil.system.domain.Module;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Set;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Taimur
 * @since 2018-10-31
 */
public interface ModuleService extends IService<Module> {

    /**后台根据用户名查询用户权限列表
     * @param userName 用户名
     * @return 用户权限列表
     */
    String getPermissionsByUserName(String userName);

    /**后台根据用户名查询模块列表
     * @param userName 用户名
     * @return 用户模块列表
     */
    List<Module> getModuleListByUserName(String userName);

    /**后台根据roleId查询模块列表
     * @param roleId 用户名
     * @return 用户模块列表
     */
    List<Module> getModuleListByRoleId(Long roleId);

    /**查询模块列表
     * @param page 页码
     * @param size 每页数量
     * @return 列表信息
     */
    IPage getModuleList(Integer page, Integer size) throws ServiceException;

    /**根据模块id查询模块
     * @param moduleId 模块id
     * @return 单个模块对象
     */
    Module getModuleByModuleId(Long moduleId) throws ServiceException;

    /**根据模块id删除模块
     * @param moduleId 模块id
     * @return 模块id
     */
    Long deleteModuleByModuleId(Long moduleId) throws ServiceException;

    /**增加模块
     * @param module 模块信息
     * @return 保存的模块id
     */
    Long saveModule(Module module) throws ServiceException;

    /**根据模块id修改模块信息
     * @param module 模块信息
     * @return 模块id
     * @throws ServiceException 自定义异常
     */
    Long updateModuleByModuleId (Module module) throws ServiceException;
}
