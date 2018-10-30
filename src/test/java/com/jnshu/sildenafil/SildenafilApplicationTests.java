package com.jnshu.sildenafil;

import com.jnshu.sildenafil.system.domain.Student;
import com.jnshu.sildenafil.system.domain.User;
import com.jnshu.sildenafil.system.service.StudentService;
import com.jnshu.sildenafil.system.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SildenafilApplicationTests {
    long TIME = System.currentTimeMillis();
    @Autowired
    StudentService studentService;
    @Test
    public void contextLoads() {
//        Student student = new Student();
//        student.setCreateAt(TIME);
//        student.setUpdateAt(TIME);
//        student.setUpdateBy("Taimur");
//        student.setNickname("tom"+student.getId());
//        student.setBean(666);
//        student.setOpenid("dsjfo;isdjfi;ldsjfli");
//        student.setEmail("fajklajf@666.com");
//        student.setPhone(12312312312l);
//        student.setGrade(1);
//        student.setStatus(0);
//        student.setImg("ifoidsjfoidsjfids");
//        student.setMaxContSign(666);
//        student.setContSign(666);
//        student.setTotalSign(666);
//        studentService.save(student);

    }

}
