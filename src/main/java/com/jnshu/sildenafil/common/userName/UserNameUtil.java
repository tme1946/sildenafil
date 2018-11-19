package com.jnshu.sildenafil.common.userName;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author feifei
 */
@Slf4j
public  class UserNameUtil {

    public static String getUsername() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
            log.info("登录的用户为" + username);
        } else {
            log.error("获取登录用户失败");
            username = principal.toString();
        }
        return username;
    }
}