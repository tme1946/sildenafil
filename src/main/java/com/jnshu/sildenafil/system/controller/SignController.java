package com.jnshu.sildenafil.system.controller;

import com.jnshu.sildenafil.common.domain.ResponseBo;
import com.jnshu.sildenafil.system.domain.Sign;
import com.jnshu.sildenafil.system.service.SignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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
    @GetMapping(value = "/a/u/front/sign")
    public ResponseBo getSignList(Long studentId) throws Exception{
        log.info("args for getSignList : studentId={}", studentId);
        if (studentId == null){
            return ResponseBo.error("参数为空，获取数据失败");
        }
        List signList = signService.getSignList(studentId);
        if (signList == null) {
            return ResponseBo.error("获取数据为空");
        }
        return ResponseBo.ok("接口通，查询签到列表成功").put("data", signList);
    }

    @ResponseBody
    @PostMapping(value = "/a/u/front/sign")
    public ResponseBo sign(Long studentId) throws Exception{
        log.info("args for sign : studentId={}",studentId);
        Boolean flag = signService.addSign(studentId);
        if (!flag) {
            return ResponseBo.error("签到失败，参数检查");
        }
        return ResponseBo.ok("接口通，签到成功").put("data", true);
    }
}
