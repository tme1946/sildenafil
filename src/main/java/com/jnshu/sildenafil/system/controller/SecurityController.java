package com.jnshu.sildenafil.system.controller;

import com.jnshu.sildenafil.common.domain.ResponseBo;
import com.jnshu.sildenafil.system.domain.Role;
import com.jnshu.sildenafil.system.domain.User;
import com.jnshu.sildenafil.system.service.ModuleService;
import com.jnshu.sildenafil.system.service.RoleService;
import com.jnshu.sildenafil.system.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author feifei
 */
@Slf4j
@Controller
public class SecurityController {
    @Autowired
    private UserService userService;
    @Autowired
    private ModuleService moduleService;
    @Autowired
    private RoleService roleService;
    /**
     * @return
     */
    @ResponseBody
    @RequestMapping("/denglu")
    public ResponseBo denglu(String userName, String password) throws Exception {
        log.info("args for userLogin: userName=[{}]&password=[{}]",userName,password);
        Long userId=userService.userLogin(userName,password);
        if(null!=userId){
            //获取用户的user和role；
            List moduleList=moduleService.getModuleListByUserName(userName);
            User user=userService.getUserByUserName(userName);
            Role role=roleService.getRoleByRoleId(user.getRoleId());
            return ResponseBo.ok("密码正确")
                    .put("user",user)
                    .put("role",role);
        }
        return ResponseBo.error("密码错误");
    }

//    /**
//     * @return
//     */
//    @RequestMapping("/error")
//    public String error() {
//
//        return "/error";
//    }
    /**
     * @return
     */
    @RequestMapping("/loginout")
    public String loginout() {

        return "/loginout";
    }
}

