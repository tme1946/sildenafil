package com.jnshu.sildenafil.system.controller;

import com.jnshu.sildenafil.common.domain.ResponseBo;
import com.jnshu.sildenafil.system.domain.Student;
import com.jnshu.sildenafil.system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @ProjectName: sildenafil
 * @Package: com.jnshu.sildenafil.system.controller
 * @ClassName: StudentController
 * @Description: java类作用描述
 * @Author: Taimur
 * @CreateDate: 2018/11/9 15:23
 */
@Controller
public class StudentController {
    @Autowired
    StudentService studentService;
    @ResponseBody
    @GetMapping(value = "/a/verify")
    public ResponseBo login(String openId){
        Student student = studentService.login(openId);
        if(student.getId() != null){
            return ResponseBo.error();
        }
        return ResponseBo.ok().put("student",student);
    }
//    @ResponseBody
//    @PostMapping(value = "/a/register")
//    public ResponseBo signup(HttpServletRequest request ){
//
//    }
}
