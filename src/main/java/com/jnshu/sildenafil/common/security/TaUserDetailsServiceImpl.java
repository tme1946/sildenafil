package com.jnshu.sildenafil.common.security;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jnshu.sildenafil.system.domain.User;
import com.jnshu.sildenafil.system.service.ModuleService;
import com.jnshu.sildenafil.system.service.UserService;
import freemarker.template.utility.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class TaUserDetailsServiceImpl implements UserDetailsService {
    @Autowired(required = false)
    private UserService userService;

    @Autowired(required = false)
    private ModuleService menuService;

    /**根据用户名加载用户认证信息
     * @param username 用户名
     * @return 用户认证信息
     */
    @Override
    public UserDetails loadUserByUsername(String username) {
        log.info("args for security's loadUserByUsername is: username={}",username);
        User user = userService.getUserByUserName(username);
        if (user != null) {
            //根据用户名得到用户权限字符串
            String permissions = menuService.getPermissionsByUserName(user.getUserName());
            System.out.println(user.getUserName() + "对应的权限为：" + permissions);
            //使用用户名密码和权限字符串生成userDetails对象
            return new MyUserDetails(user.getUserName(), user.getPassword(), true, true, true, true,
                    AuthorityUtils.commaSeparatedStringToAuthorityList(permissions));
        } else {
            log.error("result for security's loadUserByUsername error:reason is userName not exit");
            throw new UsernameNotFoundException("账号不存在");
        }
    }
}