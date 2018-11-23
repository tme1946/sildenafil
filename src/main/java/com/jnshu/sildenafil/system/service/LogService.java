package com.jnshu.sildenafil.system.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jnshu.sildenafil.system.domain.AdminLog;
import com.baomidou.mybatisplus.extension.service.IService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.scheduling.annotation.Async;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Taimur
 * @since 2018-11-12
 */
public interface LogService extends IService<AdminLog> {
    @Async
    void saveLog(ProceedingJoinPoint point, AdminLog log) throws JsonProcessingException;
}
