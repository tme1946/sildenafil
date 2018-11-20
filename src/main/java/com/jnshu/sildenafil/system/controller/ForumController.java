package com.jnshu.sildenafil.system.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jnshu.sildenafil.common.annotation.UseLog;
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
     * @param page, size, title, author, start, end
     * @return  com.jnshu.sildenafil.common.domain.ResponseBo
     */
    @UseLog("帖子列表")
    @ResponseBody
    @GetMapping(value = "/a/u/admin/forum/list")
    public ResponseBo forumList(Integer page, Integer size
            , String title, String author, Long start, Long end){
        IPage forumPage = forumService.forumFuzzySelect(page,size,title,author,start,end);
        List<Forum> forumList = forumPage.getRecords();
        List<Long> idList= forumList.stream().map(Forum::getId).collect(Collectors.toList());
        List<Student> studentList = idList.stream().map(id->studentService.getById(id)).collect(Collectors.toList());
        List<String> nameList = studentList.stream().map(Student::getNickname).collect(Collectors.toList());
        return ResponseBo.ok().put("data",forumPage).put("nickname",nameList);
    }
    /**
     *  帖子主键查询
     * @param forumId
     * @return  com.jnshu.sildenafil.common.domain.ResponseBo
     */
    @UseLog("查询帖子")
    @ResponseBody
    @GetMapping(value = "/a/u/admin/forum")
    public ResponseBo getForum(Long forumId){
        if(forumId == null){
            log.error("args for forumId is null");
            return ResponseBo.error("forumId is null");}
        Forum forum = forumService.getById(forumId);
        String nickname = studentService.getById(forum.getStudentId()).getNickname();
        return ResponseBo.ok().put("data",forum).put("nickname",nickname);
    }
}
