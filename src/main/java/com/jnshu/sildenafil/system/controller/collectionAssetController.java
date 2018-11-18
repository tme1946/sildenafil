package com.jnshu.sildenafil.system.controller;

import com.jnshu.sildenafil.common.domain.ResponseBo;
import com.jnshu.sildenafil.system.service.CollectionAssetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * #Title: collectionAssetController
 * #ProjectName sildenafil
 * #Description: TODO
 * #author lihoo
 * #date 2018/11/17-17:39
 * @author lihoo
 */

@Slf4j
@Controller
public class collectionAssetController {
    private final CollectionAssetService collectionAssetService;

    @Autowired
    public collectionAssetController(CollectionAssetService collectionAssetService) {
        this.collectionAssetService = collectionAssetService;
    }

    @ResponseBody
    @PostMapping(value = "/a/u/front/video/collection")
    public ResponseBo collect(Integer type, Long videoId, Long studentId) {
        log.info("args for collect : type={}, videoId={}, studentId={}",type,videoId,studentId);
        Long id = collectionAssetService.insertCollection(type,videoId,studentId);
        if (id == null) {
            return ResponseBo.error("参数异常，收藏失败");
        }
        return ResponseBo.ok("接口通，收藏成功").put("data", id);
    }

    @ResponseBody
    @DeleteMapping(value = "/a/u/front/video/collection")
    public ResponseBo deleteCollection(Integer type, Long videoId, Long studentId) {
        log.info("args for deleteCollection : type={}, videoId={}, studentId={}",type,videoId,studentId);
        Long vid = collectionAssetService.removeCollection(type,videoId,studentId);
        if (vid == null) {
            return ResponseBo.error("参数异常，取消收藏失败");
        }
        return ResponseBo.ok("接口通，取消收藏成功");
    }

}
