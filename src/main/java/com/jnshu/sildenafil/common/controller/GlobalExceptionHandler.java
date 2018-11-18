package com.jnshu.sildenafil.common.controller;

import com.jnshu.sildenafil.common.domain.ResponseBo;
import com.jnshu.sildenafil.common.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.Service;

/**
 * @author feifei
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

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
