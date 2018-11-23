package com.jnshu.sildenafil.system.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jnshu.sildenafil.common.domain.ResponseBo;
import com.jnshu.sildenafil.common.exception.ServiceException;
import com.jnshu.sildenafil.system.domain.Module;
import com.jnshu.sildenafil.system.domain.Role;
import com.jnshu.sildenafil.system.domain.RoleModule;
import com.jnshu.sildenafil.system.service.ModuleService;
import com.jnshu.sildenafil.system.service.RoleModuleService;
import com.jnshu.sildenafil.system.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author feifei
 */
@Slf4j
@RestController
public class RoleController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private RoleModuleService roleModuleService;
    @Autowired
    private ModuleService moduleService;
    /**查询角色列表
     * @param page 页码
     * @param size 每页数量
     * @return 列表信息
     */
//    @PreAuthorize("hasAuthority('role:list')")
    @GetMapping(value = "/a/u/admin/role/list")
    public ResponseBo getRoleList(Integer page, Integer size) throws Exception{
        log.info("args for getRoleList: page={}&size={}",page,size);
        IPage roleList=roleService.getRoleList(page,size);
        if(roleList!=null){
            return ResponseBo.ok("请求成功").put("data",roleList);

        }
        log.error("结果为空");
        return ResponseBo.error("结果异常").put("code",-1000);
    }

    /**根据角色id查询角色
     * @param roleId 角色id
     * @return 单个用户对象
     */
//    @PreAuthorize("hasAuthority('role:list')")
    @GetMapping(value = "/a/u/admin/role")
    public ResponseBo getRoleByRoleId(Long roleId) throws Exception{
        log.info("args for getRoleByRoleId: roleId={}",roleId);
        Role role =roleService.getRoleByRoleId(roleId);
        if(role!=null){
            List<RoleModule> roleModules=roleModuleService.getModuleIdListByRoleId(role.getId());
            return ResponseBo.ok().put("role",role).put("modules",roleModules);
        }
        //权限id列表
        log.error("结果为空");
        return ResponseBo.error("结果异常").put("code",-1000);
    }

    /**根据角色id删除角色
     * @param roleId 角色id
     * @return 角色id
     */
//    @PreAuthorize("hasAuthority('role:delete')")
    @DeleteMapping(value = "/a/u/admin/role")
    public ResponseBo deleteRoleByRoleId(Long roleId) throws Exception {
        log.info("args for deleteRoleByRoleId: roleId={}",roleId);
        Long roleId2=roleService.deleteRoleByRoleId(roleId);
        if(roleId2!=null){
            roleModuleService.deleteRoleModuleByRoleId(roleId);
            return ResponseBo.ok();
        }
        //删除中间表
        log.error("result for deleteRoleByRoleId fail");
        return ResponseBo.error("结果异常").put("code",-1000);
    }

    /**增加角色及角色权限信息
     * @param role 角色信息
     * @return 保存的角色id
     */
//    @PreAuthorize("hasAuthority('role:save')")
    @PostMapping(value = "/a/u/admin/role")
    public ResponseBo saveRole(Role role, ArrayList<Long> moduleIdList) throws Exception {
        log.info("args for saveRole: role={}",role);
        Long roleId2=roleService.saveRole(role);
        if(roleId2!=null){
            //插入失败抛出异常
            roleModuleService.saveRoleModuleListByRoleId(roleId2,moduleIdList);
            return ResponseBo.ok();

        }
        log.error("result for saveRole fail");
        return ResponseBo.error("结果异常").put("code",-1000);
    }

    /**更新某个角色的权限
     * @param roleId 角色id
     * @param moduleIdList 权限id集合
     * @return 角色id
     * @throws ServiceException
     * 根据角色id,先将表中改角色id的数据删除然后在循环遍历模块id列表进行增加;
     */
//    @PreAuthorize("hasAuthority('role:update')")
    @PutMapping(value = "/a/u/admin/role")
    public ResponseBo updateRoleModuleByRoleId(Long roleId, List<Long> moduleIdList)  throws Exception {
        log.info("args for updateRoleModuleByRoleId: roleId=[{}]&moduleIdList=[{}]",roleId,moduleIdList);
        Long roleId1=roleModuleService.updateRoleModuleByRoleId(roleId, moduleIdList);
        if(roleId1!=null){
            return ResponseBo.ok();
        }
        log.error("result for saveRole fail");
        return ResponseBo.error("结果异常").put("code",-1000);
    }

}
