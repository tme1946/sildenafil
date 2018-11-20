package com.jnshu.sildenafil.system.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jnshu.sildenafil.common.annotation.UseLog;
import com.jnshu.sildenafil.common.domain.ResponseBo;
import com.jnshu.sildenafil.system.domain.Student;
import com.jnshu.sildenafil.system.service.StudentService;
import com.jnshu.sildenafil.util.MyPage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @ProjectName: sildenafil
 * @Package: com.jnshu.sildenafil.system.exceptionHandler
 * @ClassName: StudentController
 * @Description: java类作用描述
 * @Author: Taimur
 * @CreateDate: 2018/11/9 15:23
 */
@Slf4j
@Controller
public class StudentController {
    @Autowired
    StudentService studentService;
    Long TIME = System.currentTimeMillis();
    /**
     * 后台Student列表
     * @param [page, size, id, nickname, grade, email, phone, status, minBean, maxBean]
     * @return  com.jnshu.sildenafil.common.domain.ResponseBo
     */
    @UseLog("学生列表")
    @ResponseBody
    @GetMapping(value = "/a/u/admin/student/list")
    public ResponseBo studentList(Integer page, Integer size
            , Long id,String nickname,Integer grade
            ,String email,Long phone,Integer status
            ,Integer minBean,Integer maxBean){
        IPage studentList = studentService.studentFuzzySelect(page,size
                ,id,nickname,grade,email,phone,status,minBean,maxBean);
        return ResponseBo.ok().put("data",studentList);
    }
    /**
     * 后台修改学生状态 （updateBY没有加）
     * @param [id]
     * @return  com.jnshu.sildenafil.common.domain.ResponseBo
     */
    @UseLog("修改学生状态")
    @ResponseBody
    @GetMapping(value = "/a/u/admin/student/state")
    public  ResponseBo changeStudentState(Long id){
        if(id == null){
            log.error("args for studentId is null");
            return ResponseBo.error("studentId is null");
        }
        Student student = studentService.getById(id);
        student.setUpdateAt(TIME);
        int state = student.getStatus() > 0? 0:1;
        student.setStatus(state);
        if(studentService.updateById(student)){
            return ResponseBo.ok().put("data",student);
        }else {
            log.error("result for changeStudentState error");
            return ResponseBo.error("change states error");
        }
    }
}
