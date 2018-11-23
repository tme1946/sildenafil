package com.jnshu.sildenafil.common.security;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author feifei
 */
@Data
@Component
@ConfigurationProperties(prefix = "tasksecurity")
public class TaSecurityProperties {
    /**
     * 登录url
     */
    private String loginUrl;
    /**
     * 登录成功url
     */
    private String loginSuccessUrl;
    /**
     * 登录失败url
     */
    private String loginFailUrl;
    /**
     * 免认证静态资源路径
     */
    private String anonResourcesUrl;
    /**
     * 记住我超时时间
     */
    private int rememberMeTimeout;
    /**
     * 登出 URL
     */
    private String logoutUrl;
    /**
     * 登出成功 URL
     */
    private String logoutSuccessUrl;
    /**
     * 主页 URL
     */
    private String indexUrl;
    /**
     * 并发登陆数
     */
    private Integer maximumSessions;

}
