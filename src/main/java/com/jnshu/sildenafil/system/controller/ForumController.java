package com.jnshu.sildenafil.system.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jnshu.sildenafil.common.domain.ResponseBo;
import com.jnshu.sildenafil.system.domain.Forum;
import com.jnshu.sildenafil.system.service.ForumService;
import com.jnshu.sildenafil.util.MyPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ProjectName: sildenafil
 * @Package: com.jnshu.sildenafil.system.controller
 * @ClassName: ForumController
 * @Description: 帖子模块Controller
 * @Author: Taimur
 * @CreateDate: 2018/11/3 14:11
 */
public class ForumController {
    @Autowired
    ForumService forumService;
    @ResponseBody
    @GetMapping(value = "/a/u/common/bbs/list")
    public ResponseBo forumList(Integer page, Integer size
            , String title, String author, Long start, Long end){
        IPage forumList = forumService.FormFuzzySelect(page,size,title,author,start,end);
        return ResponseBo.ok().put("forumList",forumList);
    }

}
