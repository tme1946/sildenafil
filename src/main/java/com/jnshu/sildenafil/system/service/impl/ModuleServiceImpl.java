package com.jnshu.sildenafil.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.jnshu.sildenafil.system.domain.Module;
import com.jnshu.sildenafil.system.domain.RoleModule;
import com.jnshu.sildenafil.system.domain.User;
import com.jnshu.sildenafil.system.mapper.ModuleDao;
import com.jnshu.sildenafil.system.mapper.RoleDao;
import com.jnshu.sildenafil.system.mapper.RoleModuleDao;
import com.jnshu.sildenafil.system.mapper.UserDao;
import com.jnshu.sildenafil.system.service.ModuleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jnshu.sildenafil.system.service.RoleModuleService;
import com.jnshu.sildenafil.system.service.RoleService;
import com.jnshu.sildenafil.system.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Taimur
 * @since 2018-10-31
 */
@Slf4j
@Service
public class ModuleServiceImpl extends ServiceImpl<ModuleDao, Module> implements ModuleService {

    @Autowired(required = false)
    private UserService userService;
    @Autowired(required = false)
    private RoleModuleService roleModuleService;
    @Autowired(required = false)
    private RoleService roleService;
    @Autowired(required = false)
    private ModuleDao moduleDao;

    /**后台根据用户名查询用户权限列表
     * @param userName 用户名
     * @return 用户权限字符串
     */
    @Override
    public String getPermissionsByUserName(String userName){
        log.info("getPermissionsByUserName's args : userName={}",userName);
            //根据userName查询user信息
            User user=userService.getUserByUserName(userName);
            if(user!=null) {
                //根据账户角色id查询moduleIdList
                   List<RoleModule> moduleIdList=roleModuleService.getModuleIdListByRoleId(user.getRoleId());
                //根据moduleIdList查询出权限集合字符串
                String permissions=moduleIdList.stream()
                        .map((roleModule)->moduleDao.selectById(roleModule.getModuleId()).getPermission())
                        .collect(Collectors.joining(","));
                log.info("result for getPermissionsByUserName is:permissions={}",permissions);
                return permissions;
            }
            log.error("result for getPermissionsByUserName error;userName format error");
        return null;
    }

    /**后台根据用户名查询模块列表
     * @param userName 用户名
     * @return 用户模块列表
     */
    @Override
    public List<Module> getModuleListByUserName(String userName){
        log.info("args for getModuleListByUserName : userName={}",userName);
        //根据userName查询user信息
        User user=userService.getUserByUserName(userName);
        if(user!=null) {
            //根据账户角色id查询moduleIdList
            List<RoleModule> moduleIdList=roleModuleService.getModuleIdListByRoleId(user.getRoleId());
            //根据moduleIdList查询出moduleList
            List<Module> moduleList=moduleIdList.stream()
                    .map((roleModule)->moduleDao.selectById(roleModule.getModuleId()))
                    .collect(Collectors.toList());
            log.info("result for getModuleListByUserName's size is:{}",moduleList.size());
            return moduleList;
        }
        log.error("result for getModuleListByUserName error;userName format error");
        return null;
    }
}
