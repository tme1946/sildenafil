package com.jnshu.sildenafil.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jnshu.sildenafil.common.exception.ServiceException;
import com.jnshu.sildenafil.common.validation.UserSave;
import com.jnshu.sildenafil.common.validation.UserUpdate;
import com.jnshu.sildenafil.system.domain.Role;
import com.jnshu.sildenafil.system.domain.User;
import com.jnshu.sildenafil.system.mapper.RoleDao;
import com.jnshu.sildenafil.system.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jnshu.sildenafil.util.MyPage;
import com.jnshu.sildenafil.util.ValidationUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class RoleServiceImpl extends ServiceImpl<RoleDao, Role> implements RoleService {
    @Autowired
    private RoleDao roleDao;
    /**查询角色列表
     * @param page 页码
     * @param size 每页数量
     * @return 列表信息
     */
    @Override
    public IPage getRoleList(Integer page, Integer size) throws ServiceException{
        log.info("args for getRoleList: page={}&size={}",page,size);
        //调整page和size默认值--
        page= null==page||page<=1 ? 1 : page;
        size= null==size||size<=1||size>20 ? 10 : size;
        IPage<Role> pageQuery=new MyPage<Role>(page,size).setDesc("update_at");
        IPage<Role> roleIPage=roleDao.selectPage( pageQuery,null);
        if(roleIPage.getRecords().size()>0)
        {
            log.info("result for getRoleList's size is {}",roleIPage.getRecords().size());
            return roleIPage;
        } else{
            log.error("result for getRoleList error :***reason is list null***");
            return null;
        }
    }

    /**根据角色id查询角色
     * @param roleId 角色id
     * @return 单个用户对象
     */
    @Override
    public Role getRoleByRoleId(Long roleId) throws ServiceException{
        log.info("args for getRoleByRoleId: roleId={}",roleId);
        if(null==roleId){
            log.error("result for getRoleByRoleId error;roleId is null");
            throw new ServiceException("getRoleByRoleId error;args null");
        }
        Role role =roleDao.selectById(roleId);
        if(role==null){
            log.error("result for getRoleByRoleId error;roleId is notExit");
            return null;
        }
        log.info("result for getRoleByRoleId is:{}",role);
        return role;
    }

    /**根据角色id删除角色
     * @param roleId 角色id
     * @return 角色id
     */
    @Override
    public Long deleteRoleByRoleId(Long roleId) throws ServiceException{
        log.info("args for deleteRoleByRoleId: roleId={}",roleId);
        if(null==roleId){
            log.error("result for deleteRoleByRoleId error;roleId is null");
            throw new ServiceException("deleteRoleByRoleId error;args null");
        }
        int i=roleDao.deleteById(roleId);
        if(i==0){
            log.error("result for deleteRoleByRoleId error;roleId is notExit");
            return null;
        }
        log.info("result for deleteRoleByRoleId's id:{}",roleId);
        return roleId;
    }

    /**增加角色
     * @param role 角色信息
     * @return 保存的角色id
     */
    @Override
    public Long saveRole(Role role) throws ServiceException{
        log.info("args for saveRole: role={}",role);
        if(null==role){
            log.error("result for saveRole error;role is null");
            throw new ServiceException("saveRole error;args null");
        }
        //校验结果抛出serviceException
        ValidationUtils.validate(role,UserSave.class);
        role.setCreateAt(System.currentTimeMillis());
        role.setCreateBy("admin");
        role.setUpdateAt(System.currentTimeMillis());
        role.setUpdateBy("admin");
        int i=roleDao.insert(role);
        if(i==0){
            log.error("result for saveUser error;save error");
            return null;
        }
        log.info("result for saveUser's id:{}",role.getId());
        return role.getId();
    }

    /**根据角色id修改角色信息
     * @param role 角色信息
     * @return 角色id
     * @throws ServiceException 自定义异常
     */
    @Override
    public Long updateRoleByRoleId(Role role) throws ServiceException{
        log.info("args for updateRoleByRoleId: role={}",role);
        if(null==role){
            log.error("result for updateRoleByRoleId error;role is null");
            throw new ServiceException("updateRoleByRoleId error;args null");
        }
        //校验结果抛出serviceException
        ValidationUtils.validate(role,UserUpdate.class);
        role.setUpdateAt(System.currentTimeMillis());
        role.setUpdateBy("admin");
        int i=roleDao.updateById(role);
        if(i==0){
            log.error("result for updateRoleByRoleId error;userId is notExit");
            return null;
        }
        log.info("result for updateRoleByRoleId's id:{}",role.getId());
        return role.getId();
    }

}

