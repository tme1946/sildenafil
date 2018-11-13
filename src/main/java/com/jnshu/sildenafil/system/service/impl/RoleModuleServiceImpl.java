package com.jnshu.sildenafil.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jnshu.sildenafil.common.exception.ServiceException;
import com.jnshu.sildenafil.common.validation.Save;
import com.jnshu.sildenafil.system.domain.RoleModule;
import com.jnshu.sildenafil.system.mapper.RoleModuleDao;
import com.jnshu.sildenafil.system.service.RoleModuleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jnshu.sildenafil.util.ValidationUtils;
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

    /**增加角色权限
     * @param roleModule 角色模块对象
     * @return 返回记录id
     */
    @Override
    public Long saveRoleModule(RoleModule roleModule) throws ServiceException{
        log.info("args for saveRoleModule: roleModule={}",roleModule);
        if(null==roleModule){
            log.error("result for saveRoleModule error;roleModule is null");
            throw new ServiceException("saveRoleModule error;args null");
        }
        //校验结果抛出serviceException
        ValidationUtils.validate(roleModule,Save.class);
        int i=roleModuleDao.insert(roleModule);
        if(i==0){
            log.error("result for saveRoleModule error;save error");
            return null;
        }
        log.info("result for saveRoleModule's id:{}",roleModule.getId());
        return roleModule.getId();
    }

    /**删除角色权限
     * @param roleId 角色id
     * @return 返回记录id
     */
    @Override
    public Long deleteRoleModuleByRoleId(Long roleId) throws ServiceException{
        log.info("args for deleteRoleModuleByRoleId: roleId={}",roleId);
        if(null==roleId){
            log.error("result for deleteRoleModuleByRoleId error;roleId is null");
            throw new ServiceException("deleteRoleModuleByRoleId error;args null");
        }
        QueryWrapper<RoleModule> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("role_id",roleId);
        int i=roleModuleDao.delete(queryWrapper);
        if(i==0){
            log.error("result for deleteRoleModuleByRoleId error;roleId is notExit");
            return null;
        }
        log.info("result for deleteRoleModuleByRoleId's id:{}",roleId);
        return roleId;
    }

    /**更新某个角色的权限
     * @param roleId 角色id
     * @param moduleIdList 权限id集合
     * @return 角色id
     * @throws ServiceException
     * 根据角色id,先将表中改角色id的数据删除然后在循环遍历模块id列表进行增加;
     */
    @Override
    public Long updateRoleModuleByRoleId(Long roleId, List<Long> moduleIdList) throws ServiceException{
        log.debug("args for updateRoleModuleByRoleId: roleId=[{}]&moduleIdList=[{}]",roleId,moduleIdList);
        if(null==roleId||moduleIdList==null||moduleIdList.size()==0){
            log.error("result for updateRoleModuleByRoleId error;args is null");
            throw new ServiceException("updateRoleModuleByRoleId error;args null");
        }
        //先进行roleId记录的删除
        QueryWrapper<RoleModule> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("role_id",roleId);
        roleModuleDao.delete(queryWrapper);
        //进行记录的插入
        RoleModule roleModule=new RoleModule();
        roleModule.setRoleId(roleId);
        //循坏遍历插入数据
        for (Long aLong : moduleIdList) {
            roleModule.setModuleId(aLong);
            roleModuleDao.insert(roleModule);
        }
        log.info("result for updateRoleModuleByRoleId's id:[{}]",roleId);
        return roleId;
    }
}
