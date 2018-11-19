package com.jnshu.sildenafil.system.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jnshu.sildenafil.common.domain.ResponseBo;
import com.jnshu.sildenafil.common.exception.ParamIsNullException;
import com.jnshu.sildenafil.common.exception.ServiceException;
import com.jnshu.sildenafil.system.domain.Video;
import com.jnshu.sildenafil.system.service.VideoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * #Title: VideoController
 * #ProjectName sildenafil
 * #Description: TODO
 * #author lihoo
 * #date 2018/11/13-11:11
 * @author lihoo
 */

@Slf4j
@Controller
public class VideoController {
    private final VideoService videoService;

    @Autowired
    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }

    @ResponseBody
    @GetMapping(value = "/a/u/admin/video")
    public ResponseBo getVideoPage(Integer page, Integer size, String title, Integer type, Integer grade, Integer subject,
                                   Integer likeStart, Integer likeEnd, Integer collectStart, Integer collectEnd,
                                   String teacher, Integer status) {
        log.info("args for getVideoPage is : page={}, size={}",page,size);
        if(page == null || size == null) {
            return ResponseBo.error("参数为空，获取数据失败");
        }
        IPage iPage = videoService.getPage(page,size,title,type,grade,subject,likeStart,likeEnd,collectStart,collectEnd,teacher,status);
        if(iPage == null){
            return ResponseBo.error("获取数据为空");
        }
        return ResponseBo.ok("接口通，成功获取数据").put("data",iPage);
    }

    @ResponseBody
    @PostMapping(value = "/a/u/admin/video")
    public ResponseBo saveVideo(Video video) throws ParamIsNullException, ServiceException {
        log.info("args for saveVideo : video={}",video);
        Video v = videoService.saveVideo(video);
        if (v == null) {
            return ResponseBo.error("参数异常，新增失败");
        }
        return ResponseBo.ok("接口通，新增成功").put("data", v.getId());
    }

    @ResponseBody
    @PutMapping(value = "/a/u/admin/video")
    public ResponseBo updateVideoById(Video video) throws ParamIsNullException, ServiceException {
        log.info("args for updateVideoById : video={}", video);
        Long vid = videoService.updateVideo(video);
        if (vid == null) {
            return ResponseBo.error("参数异常，更改失败");
        }
        return ResponseBo.ok("接口通，更新成功").put("data",vid);
    }

    @ResponseBody
    @PutMapping(value = "/a/u/admin/video/status")
    public ResponseBo updateVideoStatus(Long videoId, Integer status) throws Exception {
        log.info("args for updateVideoStatus : videoId={}, status={}", videoId, status);
        Video video = videoService.updateStatus(videoId, status);
        if (video == null) {
            return ResponseBo.error("参数异常，更改状态失败");
        }
        return ResponseBo.ok("接口通，更新状态成功").put("data", video.getStatus());
    }



}
