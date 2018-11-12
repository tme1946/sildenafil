package com.jnshu.sildenafil.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @ProjectName: sildenafil
 * @Package: com.jnshu.sildenafil.common.config
 * @ClassName: LogsProperies
 * @Description: java类作用描述
 * @Author: Taimur
 * @CreateDate: 2018/11/12 11:09
 */
@Configuration
@ConfigurationProperties(prefix = "logs")
public class LogsProperies {
    private boolean openAopLog = true;


    public boolean isOpenAopLog() {
        return openAopLog;
    }
    public void setOpenAopLog(boolean openAopLog) {
        this.openAopLog = openAopLog;
    }
}
