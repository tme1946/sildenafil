package com.jnshu.sildenafil.system.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jnshu.sildenafil.common.domain.ResponseBo;
import com.jnshu.sildenafil.system.domain.Module;
import com.jnshu.sildenafil.system.domain.Role;
import com.jnshu.sildenafil.system.domain.RoleModule;
import com.jnshu.sildenafil.system.service.ModuleService;
import com.jnshu.sildenafil.system.service.RoleModuleService;
import com.jnshu.sildenafil.system.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 24569
 */
@Slf4j
@RestController
public class ModuleController {

    @Autowired
    private RoleModuleService roleModuleService;
    @Autowired
    private ModuleService moduleService;

    /**后台根据用户名查询模块列表
     * @param userName 用户名
     * @return 用户模块列表
     */
    @GetMapping(value = "/a/u/admin/module/list")
    public ResponseBo getModuleList(String userName) throws Exception{
        log.info("args for getModuleList : userName={}",userName);
        List<Module> moduleList=moduleService.getModuleListByUserName(userName);
        if(moduleList!=null){

            return ResponseBo.ok("请求成功").put("moduleList",moduleList);
        }
        log.error("结果为空");
        return ResponseBo.error("结果异常").put("code",-1000);
    }

    /**根据模块id查询模块
     * @param moduleId 模块id
     * @return 单个模块对象
     */
    @GetMapping(value = "/a/u/admin/module")
    public ResponseBo getModule(Long moduleId) throws Exception{
        log.debug("args for getModule: moduleId=[{}]",moduleId);
        Module module =moduleService.getModuleByModuleId(moduleId);
        if(module!=null){

            return ResponseBo.ok("请求成功").put("module",module);
        }
        log.error("结果为空");
        return ResponseBo.error("结果异常").put("code",-1000);
    }

    /**根据模块id删除模块
     * @param moduleId 模块id
     * @return 模块id
     */
    @DeleteMapping(value = "/a/u/admin/module")
    public ResponseBo deleteModule(Long moduleId) throws Exception {
        log.info("args for deleteModule: moduleId={}",moduleId);
        Long moduleId1=moduleService.deleteModuleByModuleId(moduleId);
        if(moduleId1!=null){

            return ResponseBo.ok("请求成功");
        }
        log.error("结果为空");
        return ResponseBo.error("结果异常").put("code",-1000);
    }

    /**增加模块
     * @param module 模块信息
     * @return 保存的模块id
     */
    @PostMapping(value = "/a/u/admin/module")
    public ResponseBo saveModule(Module module) throws Exception {
        log.info("args for saveModule: module={}",module);
        Long moduleId=moduleService.saveModule(module);
        if(moduleId!=null){
            return ResponseBo.ok("请求成功");
        }
        log.error("结果为空");
        return ResponseBo.error("结果异常").put("code",-1000);
    }

    /**根据模块id修改模块信息
     * @param module 模块信息
     * @return 模块id
     * @throws Exception 自定义异常
     */
    @PutMapping(value = "/a/u/admin/module")
    public ResponseBo updateModuleByModuleId(Module module)  throws Exception {
        log.info("args for updateModuleByModuleId: module={}",module);
        Long moduleId=moduleService.updateModuleByModuleId(module);
        if(moduleId!=null){
            return ResponseBo.ok("请求成功");
        }
        log.error("结果为空");
        return ResponseBo.error("结果异常").put("code",-1000);
    }

}
