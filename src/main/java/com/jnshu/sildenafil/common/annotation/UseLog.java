package com.jnshu.sildenafil.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ProjectName: sildenafil
 * @Package: com.jnshu.sildenafil.common.annotation
 * @ClassName: UseLog
 * @Description: Log注解
 * @Author: Taimur
 * @CreateDate: 2018/11/1 16:44
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UseLog {
    String value() default "";
}
