package com.jnshu.sildenafil;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.Assert;
import com.jnshu.sildenafil.system.domain.Forum;
import com.jnshu.sildenafil.system.domain.Student;
import com.jnshu.sildenafil.system.domain.User;
import com.jnshu.sildenafil.system.mapper.ForumDao;
import com.jnshu.sildenafil.system.mapper.StudentDao;
import com.jnshu.sildenafil.system.service.ForumService;
import com.jnshu.sildenafil.system.service.StudentService;
import com.jnshu.sildenafil.system.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.convert.EntityWriter;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SildenafilApplicationTests {
    long TIME = System.currentTimeMillis();
    @Autowired
    StudentService studentService;
    @Autowired
    ForumDao forumDao;
    @Autowired
    StudentDao studentDao;
    @Autowired
    ForumService forumService;


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
//        System.out.println(TIME%(TIME/1000));
//        String title = "233";
//        String nickname = "tom";
//        QueryWrapper<Student> studentWrapper = new QueryWrapper<>();
//        studentWrapper.select("id").like("nickname",nickname);
//        List<Student> stuList = studentDao.selectList(studentWrapper);
//        List idList = stuList.stream().map(Student::getId).collect(Collectors.toList());
//        QueryWrapper<Forum> wrapper = new QueryWrapper<>();
//        wrapper.in("student_id",idList);
//        //wrapper.like("title",title);
//        wrapper.select("title","body","student_id");
//        List list = forumDao.selectList(wrapper);
//        for (Object o : list) {
//            System.out.println(o);
//        }
        Long id = null;
        Student student = studentService.getById(id);
        System.out.println(student);
    }

}
