package com.jnshu.sildenafil;

import com.jnshu.sildenafil.system.domain.Teacher;
import com.jnshu.sildenafil.system.service.TeacherService;
import com.jnshu.sildenafil.common.exception.ParamIsNullException;
import com.jnshu.sildenafil.common.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * #Title: TeacherTest
 * #ProjectName sildenafil
 * #Description: TODO
 * #author lihoo
 * #date 2018/11/7-11:48
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class TeacherTest {

    @Autowired
    private TeacherService teacherService;

    @Test
    public void getTeacherById() {
        String teacherName = teacherService.getTeacherById(3L).getNickname();
        System.out.println(teacherName);
    }

    @Test
    public void addTeacher() throws ServiceException, ParamIsNullException {
        Teacher t = new Teacher();
        t.setNickname("李白");
        t.setImg("yashilali");
        Teacher aaa = teacherService.saveTeacher(t);
        System.out.println(aaa);
    }

    @Test
    public void getNameList() {
        teacherService.getTeacherNameList().forEach(System.out::println);

    }
}
