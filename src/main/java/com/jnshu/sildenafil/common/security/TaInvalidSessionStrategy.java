package com.jnshu.sildenafil.common.security;

import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.session.InvalidSessionStrategy;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 处理 session 失效
 */

public class TaInvalidSessionStrategy implements InvalidSessionStrategy {

    private TaSecurityProperties securityProperties;

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();


    @Override
    public void onInvalidSessionDetected(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //返回登陆界面
        System.out.println(request);
        System.out.println(response);
        System.out.println(securityProperties.getLogoutUrl());
        redirectStrategy.sendRedirect(request, response, securityProperties.getLogoutUrl());
    }

    public TaSecurityProperties getSecurityProperties() {
        return securityProperties;
    }

    public void setSecurityProperties(TaSecurityProperties securityProperties) {
        this.securityProperties = securityProperties;
    }
}
