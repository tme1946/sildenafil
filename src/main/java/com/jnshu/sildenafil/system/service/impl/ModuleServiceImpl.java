package com.jnshu.sildenafil.system.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jnshu.sildenafil.common.exception.ServiceException;
import com.jnshu.sildenafil.common.validation.Save;
import com.jnshu.sildenafil.common.validation.Update;
import com.jnshu.sildenafil.common.validation.UserSave;
import com.jnshu.sildenafil.common.validation.UserUpdate;
import com.jnshu.sildenafil.system.domain.Module;
import com.jnshu.sildenafil.system.domain.RoleModule;
import com.jnshu.sildenafil.system.domain.User;
import com.jnshu.sildenafil.system.mapper.ModuleDao;
import com.jnshu.sildenafil.system.service.ModuleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jnshu.sildenafil.system.service.RoleModuleService;
import com.jnshu.sildenafil.system.service.RoleService;
import com.jnshu.sildenafil.system.service.UserService;
import com.jnshu.sildenafil.util.MyPage;
import com.jnshu.sildenafil.util.ValidationUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    /**查询模块列表
     * @param page 页码
     * @param size 每页数量
     * @return 列表信息
     */
    @Override
    public IPage getModuleList(Integer page, Integer size) throws ServiceException{
        log.info("args for getModuleList: page={}&size={}",page,size);
        //调整page和size默认值--
        page= null==page||page<=1 ? 1 : page;
        size= null==size||size<=1||size>20 ? 10 : size;
        IPage<Module> pageQuery=new MyPage<Module>(page,size).setDesc("update_at");
        IPage<Module> moduleIPage=moduleDao.selectPage( pageQuery,null);
        if(moduleIPage.getRecords().size()>0)
        {
            log.info("result for getModuleList's size is {}",moduleIPage.getRecords().size());
            return moduleIPage;
        } else{
            log.error("result for getModuleList error :***reason is list null***");
            return null;
        }
    }

    /**根据模块id查询模块
     * @param moduleId 模块id
     * @return 单个模块对象
     */
    @Override
    public Module getModuleByModuleId(Long moduleId) throws ServiceException{
        log.debug("args for getModuleByModuleId: moduleId=[{}]",moduleId);
        if(null==moduleId){
            log.warn("result for getModuleByModuleId error;moduleId is null");
            throw new ServiceException("getModuleByModuleId error;args null");
        }else {
            Module module =moduleDao.selectById(moduleId);
            if(module==null){
                log.warn("result for getModuleByModuleId error;moduleId is notExit");
                return null;
            }
            log.info("result for getModuleByModuleId is:[{}]",module);
            return module;
        }
    }

    /**根据模块id删除模块
     * @param moduleId 模块id
     * @return 模块id
     */
    @Override
    public Long deleteModuleByModuleId(Long moduleId) throws ServiceException{
        log.info("args for deleteModuleByModuleId: moduleId={}",moduleId);
        if(null==moduleId){
            log.error("result for deleteModuleByModuleId error;moduleId is null");
            throw new ServiceException("deleteModuleByModuleId error;args null");
        }
        int i=moduleDao.deleteById(moduleId);
        if(i==0){
            log.error("result for deleteModuleByModuleId error;moduleId is notExit");
            return null;
        }
        log.info("result for deleteModuleByModuleId's id:{}",moduleId);
        return moduleId;
    }

    /**增加模块
     * @param module 模块信息
     * @return 保存的模块id
     */
    @Override
    public Long saveModule(Module module) throws ServiceException{
        log.info("args for saveModule: module={}",module);
        if(null==module){
            log.error("result for saveModule error;module is null");
            throw new ServiceException("saveModule error;args null");
        }
        //校验结果抛出serviceException
        ValidationUtils.validate(module,Save.class);
        module.setCreateAt(System.currentTimeMillis());
        module.setCreateBy("admin");
        module.setUpdateAt(System.currentTimeMillis());
        module.setUpdateBy("admin");
        int i=moduleDao.insert(module);
        if(i==0){
            log.error("result for saveModule error;save error");
            return null;
        }
        log.info("result for saveModule's id:{}",module.getId());
        return module.getId();
    }

    /**根据模块id修改模块信息
     * @param module 模块信息
     * @return 模块id
     * @throws ServiceException 自定义异常
     */
    @Override
    public Long updateModuleByModuleId(Module module) throws ServiceException{
        log.info("args for updateModuleByModuleId: module={}",module);
        if(null==module){
            log.error("result for updateModuleByModuleId error;module is null");
            throw new ServiceException("updateModuleByModuleId error;args null");
        }
        //校验结果抛出serviceException
        ValidationUtils.validate(module,Update.class);
        module.setUpdateAt(System.currentTimeMillis());
        module.setUpdateBy("admin");
        int i=moduleDao.updateById(module);
        if(i==0){
            log.error("result for updateModuleByModuleId error;moduleId is notExit");
            return null;
        }
        log.info("result for updateModuleByModuleId's id:{}",module.getId());
        return module.getId();
    }
}
