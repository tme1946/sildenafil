package com.jnshu.sildenafil.util;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * @ProjectName: sildenafil
 * @Package: com.jnshu.sildenafil.util
 * @ClassName: HttpContextUtils
 * @Description: 获取HttpRequest
 * @Author: Taimur
 * @CreateDate: 2018/11/1 16:48
 */
public class HttpContextUtils {

    private HttpContextUtils(){

    }
    public static HttpServletRequest getHttpServletRequest() {
        return ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
    }
}
