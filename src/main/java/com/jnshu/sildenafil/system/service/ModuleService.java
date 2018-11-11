package com.jnshu.sildenafil.system.service;

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

}
