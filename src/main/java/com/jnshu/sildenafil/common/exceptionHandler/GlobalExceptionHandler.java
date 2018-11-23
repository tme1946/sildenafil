package com.jnshu.sildenafil.common.exceptionHandler;

import com.jnshu.sildenafil.common.domain.ResponseBo;
import com.jnshu.sildenafil.common.exception.ParamIsNullException;
import com.jnshu.sildenafil.common.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import java.nio.file.AccessDeniedException;

/**
 * @author feifei
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(AccessDeniedException.class)
    @ResponseBody
    public ResponseBo accessDeniedException(HttpServletRequest request, AccessDeniedException se){
        ResponseBo responseBo=ResponseBo.error();
        responseBo.put("message","没有权限");
        log.error("**调用controller出错;前端得到的出错信息:{};具体信息为:{},出错的请求地址为:{}**"
                ,"没有权限",se.getMessage(),request.getRequestURL().toString());
        return responseBo;
    }

    @ExceptionHandler(AuthenticationException.class)
    @ResponseBody
    public ResponseBo authenticationException(HttpServletRequest request, AuthenticationException se){
        ResponseBo responseBo=ResponseBo.error();
        responseBo.put("message","认证错误");
        log.error("**调用controller出错;前端得到的出错信息:{};具体信息为:{},出错的请求地址为:{}**"
                ,"认证错误",se.getMessage(),request.getRequestURL().toString());
        return responseBo;
    }

    @ExceptionHandler(ParamIsNullException.class)
    @ResponseBody
    public ResponseBo paramIsNullException(HttpServletRequest request, ParamIsNullException se){
        ResponseBo responseBo=ResponseBo.error();
        responseBo.put("message","参数输入错误");
        log.error("**调用controller出错;前端得到的出错信息:{};具体信息为:{},出错的请求地址为:{}**"
                ,"参数输入错误",se.getMessage(),request.getRequestURL().toString());
        return responseBo;
    }

    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    public ResponseBo serviceException(HttpServletRequest request, ServiceException se){
        ResponseBo responseBo=ResponseBo.error();
        responseBo.put("message","参数输入错误");
        log.error("**调用controller出错;前端得到的出错信息:{};具体信息为:{},出错的请求地址为:{}**"
                ,"参数输入错误",se.getMessage(),request.getRequestURL().toString());
        return responseBo;
    }


    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseBo errorHandler(HttpServletRequest request, Exception e)  {
        ResponseBo responseBo=ResponseBo.error();
        responseBo.put("message","未知错误");
        log.error("**调用controller出错;前端得到的信息:{};具体信息为:{},出错的请求地址为:{}**"
                ,"未知错误",e.getMessage(),request.getRequestURL().toString());
        return responseBo;
    }
}
