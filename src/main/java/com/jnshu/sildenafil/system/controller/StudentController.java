package com.jnshu.sildenafil.system.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jnshu.sildenafil.common.domain.ResponseBo;
import com.jnshu.sildenafil.system.domain.Student;
import com.jnshu.sildenafil.system.service.StudentService;
import com.jnshu.sildenafil.util.MyPage;
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
    /**
     * 验证登陆方法
     * @param [openId]
     * @return  com.jnshu.sildenafil.common.domain.ResponseBo
     */
    @ResponseBody
    @GetMapping(value = "/a/verify")
    public ResponseBo login(String openId){
        Student student = studentService.login(openId);
        if(student.getId() != null){
            return ResponseBo.error();
        }
        return ResponseBo.ok().put("student",student);
    }

    //此处写注册流程


    /**
     * 后台Student列表
     * @param [page, size, id, nickname, grade, email, phone, status, minBean, maxBean]
     * @return  com.jnshu.sildenafil.common.domain.ResponseBo
     */
    @ResponseBody
    @GetMapping(value = "/a/u/admin/student/list")
    public ResponseBo studentList(Integer page, Integer size
            , Long id,String nickname,Integer grade
            ,String email,Long phone,Integer status
            ,Integer minBean,Integer maxBean){
        IPage studentList = studentService.studentFuzzySelect(page,size
                ,id,nickname,grade,email,phone,status,minBean,maxBean);
        return ResponseBo.ok().put("studentList",studentList);

    }


}
