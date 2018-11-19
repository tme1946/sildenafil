package com.jnshu.sildenafil.system.controller;

import com.jnshu.sildenafil.common.domain.ResponseBo;
import com.jnshu.sildenafil.common.exception.ParamIsNullException;
import com.jnshu.sildenafil.common.exception.ServiceException;
import com.jnshu.sildenafil.system.domain.Teacher;
import com.jnshu.sildenafil.system.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * #Title: TeacherController
 * #ProjectName sildenafil
 * #Description: TODO
 * #author lihoo
 * #date 2018/11/17-15:31
 * @author lihoo
 */

@Slf4j
@Controller
public class TeacherController {
    private final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @ResponseBody
    @PostMapping(value = "/a/u/admin/teacher")
    public ResponseBo saveTeacher(Teacher teacher)  throws ServiceException, ParamIsNullException {
        log.info("args for saveTeacher is: teacher={}", teacher);
        Teacher t = teacherService.saveTeacher(teacher);
        if (t == null) {
            return ResponseBo.error("参数异常，新增失败");
        }
        return ResponseBo.ok("接口通，新增成功").put("data", t.getId());
    }

    @ResponseBody
    @DeleteMapping(value = "/a/u/admin/teacher")
    public ResponseBo deleteTeacher(Long teacherId) throws Exception {
        log.info("args for deleteTeacher is: teacherId={}", teacherId);
        Boolean flag = teacherService.removeTeacherById(teacherId);
        if (!flag) {
            return ResponseBo.error("参数异常，删除失败");
        }
        return ResponseBo.ok("接口通，删除成功");
    }

    @ResponseBody
    @GetMapping(value = "/a/u/admin/teacher/list")
    public ResponseBo getTeacherNameList() {
        log.info("getTeacherNameList no args");
        List teacherNameList = teacherService.getTeacherNameList();
        if (teacherNameList == null) {
            return ResponseBo.error("参数异常，数据获取失败");
        }
        return ResponseBo.ok("接口通，成功获取数据").put("data", teacherNameList);
    }

    @ResponseBody
    @GetMapping(value = "/a/u/admin/teacher")
    public ResponseBo getTeacherById(Long teacherId) throws Exception{
        log.info("args for getTeacherById is: teacherId={}", teacherId);
        Teacher t = teacherService.getTeacherById(teacherId);
        if (t == null) {
            return ResponseBo.error("参数异常，获取数据失败");
        }
        return ResponseBo.ok("接口通，成功获取数据").put("data", t);
    }

}
