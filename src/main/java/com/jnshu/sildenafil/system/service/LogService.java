package com.jnshu.sildenafil.system.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jnshu.sildenafil.system.domain.Log;
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
public interface LogService extends IService<Log> {
    @Async
    void saveLog(ProceedingJoinPoint point, Log log) throws JsonProcessingException;
}
