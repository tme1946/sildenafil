package com.jnshu.sildenafil.common.security.config;


import com.jnshu.sildenafil.common.security.TaExpiredSessionStrategy;
import com.jnshu.sildenafil.common.security.TaInvalidSessionStrategy;
import com.jnshu.sildenafil.common.security.TaSecurityProperties;
import com.jnshu.sildenafil.common.security.TaUserDetailsServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.session.InvalidSessionStrategy;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;

import javax.sql.DataSource;

/**拦截配置类
 *
 * @author 24569
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("serviceRMI");
    }
    @Autowired(required = false)
    TaSecurityProperties taSecurityProperties;
    @Autowired(required = false)
    TaUserDetailsServiceImpl taUserDetailsServiceImpl;
    @Autowired(required = false)
    private DataSource dataSource;

    /**数据库保存rememberMe状态
     * @return 持久化token仓库位置
     */
    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();

        jdbcTokenRepository.setDataSource(dataSource);
        //true表示在数据库创建表；
        jdbcTokenRepository.setCreateTableOnStartup(false);
        return jdbcTokenRepository;
    }

    /**自定义失效session失效策略，指定失效后的重定向网址
     * @return session失效策略
     */
    @Bean
    public InvalidSessionStrategy invalidSessionStrategy(){
        return new TaInvalidSessionStrategy();
    }

    /**自定义session过期策略，处理并发登陆
     * @return session过期策略
     */
    @Bean
    public SessionInformationExpiredStrategy sessionInformationExpiredStrategy(){
        return new TaExpiredSessionStrategy();
    }

    /**
     * @return session注册中心
     */
    @Bean
    public SessionRegistry sessionRegistry() {
        return new SessionRegistryImpl();
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //将路径字符串拆分成字符数组
        String[] anonResourcesUrl =
                StringUtils.splitByWholeSeparatorPreserveAllTokens(taSecurityProperties.getAnonResourcesUrl(),",");

        http
                .csrf().disable()//关闭csrf认证
                .authorizeRequests() //任何请求所有认证
                .antMatchers(anonResourcesUrl).permitAll()//不认证资源
//                .antMatchers("/academic/front/**").hasAuthority("student")
                .anyRequest().authenticated()
                .and()
                .formLogin()// 表单登录
                .loginProcessingUrl(taSecurityProperties.getLoginUrl()) // 登录 Action 的 URI
                .loginPage(taSecurityProperties.getLoginUrl()) // 登录页面 URI
                .successForwardUrl(taSecurityProperties.getLoginSuccessUrl())
                .failureForwardUrl(taSecurityProperties.getLoginFailUrl())
                .and()
                .rememberMe() // 添加记住我功能
                .tokenRepository(persistentTokenRepository()) // 配置 token 持久化仓库
                .tokenValiditySeconds(taSecurityProperties.getRememberMeTimeout()) // rememberMe 过期时间，秒登录
                .userDetailsService(taUserDetailsServiceImpl) // 处理自动登录逻辑
                .and()
                .sessionManagement()//配置 session管理器
                .invalidSessionStrategy(invalidSessionStrategy())//处理 session失效,可不配，使用默认
                .maximumSessions(taSecurityProperties.getMaximumSessions())//最大并发登录数
                .expiredUrl(taSecurityProperties.getLoginUrl())//失效后的重定向地址
//                .expiredSessionStrategy(sessionInformationExpiredStrategy())//处理并发登录被踢出后的吹,自定义类
//                .maxSessionsPreventsLogin(false)//false后登录踢掉前登录,true则不允许之后登录，默认为false
                .sessionRegistry(sessionRegistry())//配置 session注册中心，可不配，使用默认
                .and()
                // 登录失败后的页面URI
                .and()
                .logout().logoutUrl(taSecurityProperties.getLogoutUrl())//登出url
                .logoutSuccessUrl(taSecurityProperties.getLoginUrl());//登出后的跳转
//        http.authorizeRequests().anyRequest().permitAll();//任何请求不用认证
//        http.addFilterBefore(myFilterSecurityInterceptor, FilterSecurityInterceptor.class);
    }


    /**spring security自带的密码加密工具,md5加盐严密
     * @return 加密工具类
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //user Details Service验证,指定使用默认密码加密方式；不指定为默认；
        auth.userDetailsService(taUserDetailsServiceImpl).passwordEncoder(passwordEncoder());
    }
}
