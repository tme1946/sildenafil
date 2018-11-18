package com.jnshu.sildenafil.system.controller;

import com.jnshu.sildenafil.common.domain.ResponseBo;
import com.jnshu.sildenafil.system.service.LikeAssetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * #Title: LikeAssetController
 * #ProjectName sildenafil
 * #Description: TODO
 * #author lihoo
 * #date 2018/11/17-16:19
 * @author lihoo
 */

@Slf4j
@Controller
public class LikeAssetController {
    private final LikeAssetService likeAssetService;

    @Autowired
    public LikeAssetController(LikeAssetService likeAssetService) {
        this.likeAssetService = likeAssetService;
    }

    @ResponseBody
    @PostMapping(value = "/a/u/front/video/like")
    public ResponseBo like(Integer type, Long videoId, Long studentId) {
        log.info("args for like : type={}, videoId={}, studentId={}",type,videoId,studentId);
        Long id = likeAssetService.insertLike(type,videoId,studentId);
        if (id == null) {
            return ResponseBo.error("参数异常，点赞失败");
        }
        return ResponseBo.ok("接口通，点赞成功").put("data", id);
    }




}
