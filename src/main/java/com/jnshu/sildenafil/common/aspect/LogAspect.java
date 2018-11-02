package com.jnshu.sildenafil.common.aspect;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jnshu.sildenafil.util.HttpContextUtils;
import com.jnshu.sildenafil.util.IPUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @ProjectName: sildenafil
 * @Package: com.jnshu.sildenafil.common.aspect
 * @ClassName: LogAspect
 * @Description: 切面类
 * @Author: Taimur
 * @CreateDate: 2018/11/1 16:45
 */
@Aspect
@Component
public class LogAspect {

    private Logger log = LoggerFactory.getLogger(this.getClass());

//    @Autowired
//    private FebsProperies febsProperies;
//
//    @Autowired
//    private LogService logService;


    @Pointcut("@annotation(com.jnshu.task.common.annotation.Log)")
    public void pointcut() {
        // do nothing
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point) throws JsonProcessingException {
        Object result = null;
        long beginTime = System.currentTimeMillis();
        try {
            // 执行方法
            result = point.proceed();
        } catch (Throwable e) {
            log.error(e.getMessage());
        }
        // 执行时长(毫秒)
        // 获取request
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        // 设置IP地址
        String ip = IPUtils.getIpAddr(request);
        long time = System.currentTimeMillis() - beginTime;
//        if (febsProperies.isOpenAopLog()) {
//            // 保存日志
//            //User user = (User) SecurityUtils.getSubject().getPrincipal();
//            SysLog log = new SysLog();
//            log.setUsername("tme");//user.getUsername());
//            log.setIp(ip);
//            log.setTime(time);
//            logService.saveLog(point, log);
//        }
        return result;
    }
}