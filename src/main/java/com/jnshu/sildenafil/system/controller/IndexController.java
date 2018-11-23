package com.jnshu.sildenafil.system.controller;

import com.jnshu.sildenafil.common.domain.ResponseBo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author feifei
 */
@Slf4j
@Controller
public class IndexController {

    @ResponseBody
    @RequestMapping(value = "/")
    public ResponseBo index222(){
        return ResponseBo.ok("已经进入首页");
    }
}
