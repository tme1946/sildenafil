package com.jnshu.sildenafil.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jnshu.sildenafil.system.domain.RoleModule;
import com.jnshu.sildenafil.system.mapper.RoleModuleDao;
import com.jnshu.sildenafil.system.service.RoleModuleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
public class RoleModuleServiceImpl extends ServiceImpl<RoleModuleDao, RoleModule> implements RoleModuleService {

    @Autowired(required = false)
    private RoleModuleDao roleModuleDao;

    /**后台根据roleId查询menuId列表
     * @param roleId 角色id
     * @return menuId列表列表
     */
    @Override
    public List<RoleModule> getModuleIdListByRoleId(Long roleId){
        log.info("args for getModuleIdListByRoleId's : roleId={}",roleId);
        if(null!=roleId){
            QueryWrapper<RoleModule> roleModuleQueryWrapper = new QueryWrapper<>();
            roleModuleQueryWrapper.eq("role_id", roleId);
            List<RoleModule> moduleIdList=roleModuleDao.selectList(roleModuleQueryWrapper);
            if(moduleIdList.size()==0){
                log.error("result for getModuleIdListByRoleId error;roleId is notExit");
                return null;
            }
            log.info("result for getModuleIdListByRoleId:{}",moduleIdList);
            return moduleIdList;
        }
        log.error("result for getModuleIdListByRoleId error;roleId is null");
        return null;
    }
}
