package com.jnshu.sildenafil.system.service;

import com.jnshu.sildenafil.system.domain.RoleModule;
import com.baomidou.mybatisplus.extension.service.IService;

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
}
