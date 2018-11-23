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
public class CollectionAssetController {
    private final CollectionAssetService collectionAssetService;

    @Autowired
    public CollectionAssetController(CollectionAssetService collectionAssetService) {
        this.collectionAssetService = collectionAssetService;
    }

    @ResponseBody
    @PostMapping(value = "/a/u/front/video/collection")
    public ResponseBo collect(Long videoId, Long studentId) throws Exception {
        log.info("args for collect : videoId={}, studentId={}",videoId,studentId);
        Long id = collectionAssetService.insertCollection(1,videoId,studentId);
        if (id == null) {
            return ResponseBo.error("参数异常，收藏失败");
        }
        return ResponseBo.ok("接口通，收藏成功").put("data", id);
    }

    @ResponseBody
    @DeleteMapping(value = "/a/u/front/video/collection")
    public ResponseBo deleteCollection( Long videoId, Long studentId) throws Exception {
        log.info("args for deleteCollection : videoId={}, studentId={}",videoId,studentId);
        Long vid = collectionAssetService.removeCollection(1,videoId,studentId);
        if (vid == null) {
            return ResponseBo.error("参数异常，取消收藏失败");
        }
        return ResponseBo.ok("接口通，取消收藏成功");
    }

}
