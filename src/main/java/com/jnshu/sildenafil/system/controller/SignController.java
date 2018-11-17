package com.jnshu.sildenafil.system.controller;

import com.jnshu.sildenafil.common.domain.ResponseBo;
import com.jnshu.sildenafil.system.service.SignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * #Title: SignController
 * #ProjectName sildenafil
 * #Description: TODO
 * #author lihoo
 * #date 2018/11/14-13:44
 * @author lihoo
 */

@Slf4j
@Controller
public class SignController {
    @Autowired
    private SignService signService;

    @ResponseBody
    @GetMapping(value = "/a/u/front/sign{id}")
    public ResponseBo getSignList() {

        return null;
    }

    @ResponseBody
    @PostMapping(value = "/a/u/front/sign{id}")
    public ResponseBo sign() {


        return null;
    }
}
