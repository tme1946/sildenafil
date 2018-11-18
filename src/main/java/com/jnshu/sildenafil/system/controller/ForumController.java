package com.jnshu.sildenafil.system.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jnshu.sildenafil.common.domain.ResponseBo;
import com.jnshu.sildenafil.system.domain.Forum;
import com.jnshu.sildenafil.system.domain.Student;
import com.jnshu.sildenafil.system.service.ForumService;
import com.jnshu.sildenafil.system.service.StudentService;
import com.jnshu.sildenafil.util.MyPage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ProjectName: sildenafil
 * @Package: com.jnshu.sildenafil.system.exceptionHandler
 * @ClassName: ForumController
 * @Description: 帖子模块Controller
 * @Author: Taimur
 * @CreateDate: 2018/11/3 14:11
 */
@Slf4j
@Controller
public class ForumController {
    @Autowired
    ForumService forumService;
    @Autowired
    StudentService studentService;
    /**
     * 后台帖子列表
     * @param [page, size, title, author, start, end]
     * @return  com.jnshu.sildenafil.common.domain.ResponseBo
     */
    @ResponseBody
    @GetMapping(value = "/a/u/admin/forum/list")
    public ResponseBo forumList(Integer page, Integer size
            , String title, String author, Long start, Long end){
        IPage forumList = forumService.forumFuzzySelect(page,size,title,author,start,end);
        return ResponseBo.ok().put("forumList",forumList);
    }
    /**
     * 前台帖子列表（附带输出学生昵称，头像）
     * @param [page, size]
     * @return  com.jnshu.sildenafil.common.domain.ResponseBo
     */
    @ResponseBody
    @GetMapping(value = "/a/u/front/forum/list")
    public ResponseBo frontForumList(Integer page,Integer size){
        IPage<Forum> forumIPage = forumService.forumFrontList(page,size);
        List<Forum> forumList = forumIPage.getRecords();
        List<Long> idList = forumList.stream().map(Forum::getStudentId).collect(Collectors.toList());
        List<Student> studentList = idList.stream().map((id)->studentService.getById(id)).collect(Collectors.toList());
        List imgList = studentList.stream().map(Student::getImg).collect(Collectors.toList());
        List nicknameList = studentList.stream().map(Student::getNickname).collect(Collectors.toList());
        return ResponseBo.ok().put("forumList",forumList)
                .put("nicknameList",nicknameList).put("imgList",imgList);
    }


}
