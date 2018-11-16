package com.jnshu.sildenafil.system.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jnshu.sildenafil.common.domain.ResponseBo;
import com.jnshu.sildenafil.common.exception.ServiceException;
import com.jnshu.sildenafil.system.domain.Role;
import com.jnshu.sildenafil.system.domain.User;
import com.jnshu.sildenafil.system.mapper.RoleDao;
import com.jnshu.sildenafil.system.service.RoleService;
import com.jnshu.sildenafil.system.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author feifei
 */
@Slf4j
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    /**条件查询用户列表
     * @param page 页码
     * @param size 每页数量
     * @param roleId 角色id
     * @param userName 用户名
     * @return 列表信息
     */
    @GetMapping(value = "/a/u/admin/user/list")
    public ResponseBo getUserList(Integer page, Integer size, Long roleId, String userName)throws Exception{
        log.info("args for getUserList: page={}&size={}&roleId={}&userName={}",page,size,roleId,userName);
        IPage<User> userList=userService.getUserList(page,size,roleId,userName);
        List<Role> roleList=roleService.getRoleListByUserList(userList);
        if(roleList==null){
            log.error("结果为空");
            return ResponseBo.error("参数异常");
        }
        return ResponseBo.ok("请求成功").put("userList",userList).put("userNameList",roleList);
    }

    /**根据用户id查询用户
     * @param userId 用户id
     * @return 单个用户对象
     */
    @GetMapping(value = "/a/u/admin/user")
    public ResponseBo getUserByUserId(Long userId) throws Exception{
        log.info("args for getUserByUserId: userId={}",userId);
        User user=userService.getUserByUserId(userId);
        if(user==null){
            log.error("结果为空");
            return ResponseBo.error("参数异常");
        }
        Role role=roleService.getRoleByRoleId(user.getRoleId());
        return ResponseBo.ok().put("user",user).put("role",role);
    }

    /**增加用户
     * @param user 用户信息
     * @return 保存的用户id
     */
    @PostMapping(value = "/a/u/admin/user")
    public ResponseBo saveUser(User user) throws Exception {
        log.info("args for saveUser: user={}",user);
        Long userId=userService.saveUser(user);
        if(userId==null){
            log.error("插入失败");
            return ResponseBo.error("插入失败");
        }
        return ResponseBo.ok();
    }

    /**根据用户id修改用户信息
     * @param user 用户信息
     * @return 用户id
     */
    @PutMapping(value = "/a/u/admin/user")
    public ResponseBo updateUserByUserId(User user) throws Exception {
        log.info("args for updateUserByUserId: user={}",user);
        Long userId=userService.updateUserByUserId(user);
        if(userId==null){
            log.error("更新失败");
            return ResponseBo.error("更新失败");
        }
        return ResponseBo.ok();
    }

    /**根据用户id修改用户密码
     * @param userId 用户id
     * @param passwordOld 旧密码
     * @param passwordNew 新密码
     * @return 用户id
     * @throws ServiceException 自定义异常
     */
    @PutMapping(value = "/a/u/admin/user/password")
    public ResponseBo updateUserPasswordByUserId(String passwordOld, String passwordNew, Long userId) throws Exception {
        log.info("args for updateUserPasswordByUserId: passwordOld={}&passwordNew={}&userId={}",passwordOld,passwordNew,userId);
        Long userId1=userService.updateUserPasswordByUserId(passwordOld,passwordNew,userId);
        if(userId1==null){
            log.error("参数异常或密码错误");
            return ResponseBo.error("修改失败");
        }
        return ResponseBo.ok();
    }
}
