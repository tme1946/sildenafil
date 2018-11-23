package com.jnshu.sildenafil;


import com.jnshu.sildenafil.system.mapper.ForumDao;
import com.jnshu.sildenafil.system.mapper.StudentDao;
import com.jnshu.sildenafil.system.service.ForumService;
import com.jnshu.sildenafil.system.service.LogService;
import com.jnshu.sildenafil.system.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=SildenafilApplication.class)
@Slf4j
public class SildenafilApplicationTests {
    @Autowired
    StudentService studentService;
    @Autowired
    LogService logService;
    @Test
    public void name() {
        System.out.println(logService.getById(2));
        System.out.println(studentService.getById(2));
    }
}
