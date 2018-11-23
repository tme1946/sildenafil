package com.jnshu.sildenafil.system.controller;

import com.jnshu.sildenafil.common.domain.ResponseBo;
import com.jnshu.sildenafil.common.userName.UserNameUtil;
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

    /**用来接收注销的用户并输出信息
     * @return
     */
    @ResponseBody
    @RequestMapping("/a/logout/success")
    public ResponseBo logout()  {
        //注销登陆
        return ResponseBo.ok("注销成功");
    }

    /** 登陆成功后输出user和role信息
     * @return 登陆成功的uer和role信息
     * @throws Exception 抛出异常
     */
    @ResponseBody
    @RequestMapping("/a/login/success")
    public ResponseBo loginSuccess() throws Exception {
        String userName=UserNameUtil.getUsername();
        log.info("args for userLogin: userName=[{}]",userName);
        if(null!=userName){
            //获取用户的user和role；
            User user=userService.getUserByUserName(userName);
            Role role=roleService.getRoleByRoleId(user.getRoleId());
            return ResponseBo.ok("密码正确")
                    .put("user",user)
                    .put("role",role);
        }
        return ResponseBo.ok("没有信息");
    }

    /**登陆失败处理的类
     * @return 密码错误
     */
    @ResponseBody
    @RequestMapping("/a/fail")
    public ResponseBo loginFail() {
        //获取用户的user和role；
        return ResponseBo.error("密码错误");
    }

}

