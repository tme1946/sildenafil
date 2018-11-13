package com.jnshu.sildenafil.system.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jnshu.sildenafil.common.domain.ResponseBo;
import com.jnshu.sildenafil.system.service.VideoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * #Title: VideoController
 * #ProjectName sildenafil
 * #Description: TODO
 * #author lihoo
 * #date 2018/11/13-11:11
 */

@Slf4j
@Controller
public class VideoController {
    @Autowired
    private VideoService videoService;

    @ResponseBody
    @GetMapping(value = "/a/u/admin/video/")
    public ResponseBo getVideoPage(Integer page, Integer size, String title, Integer type, Integer grade, Integer subject,
                                   Integer likeStart, Integer likeEnd, Integer collectStart, Integer collectEnd,
                                   String teacher, Integer status) {
        if(page == null || size == null) {
            log.error("args is null");
            return ResponseBo.error("page or size is null");
        }
        log.info("args for getVideoPage is : page={}, size={}",page,size);
        IPage iPage = videoService.getPage(page,size,title,type,grade,subject,likeStart,likeEnd,collectStart,collectEnd,teacher,status);
        if(iPage != null){
            log.info("result for getVideoPage is : iPage={}",iPage);
            return ResponseBo.ok().put("data",iPage);
        }else{
            log.error("result for getVideoPage is not exist");
            return ResponseBo.error("iPage not exist");
        }
    }



}
