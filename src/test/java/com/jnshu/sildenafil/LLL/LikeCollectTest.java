package com.jnshu.sildenafil.LLL;

import com.jnshu.sildenafil.system.service.CollectionAssetService;
import com.jnshu.sildenafil.system.service.LikeAssetService;
import com.jnshu.sildenafil.system.service.VideoService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * #Title: LikeCollectTest
 * #ProjectName sildenafil
 * #Description: TODO
 * #author lihoo
 * #date 2018/11/10-20:32
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LikeCollectTest {

    @Autowired
    private VideoService videoService;

    @Autowired
    private LikeAssetService likeAssetService;

    @Autowired
    private CollectionAssetService collectionAssetService;

    @Test
    public void like() throws Exception{
        Long aaa = likeAssetService.insertLike(1, 1L, 1L);
        System.out.println(aaa);
    }

    @Test
    public void likeStatus() throws Exception{
        int aaa =  likeAssetService.selectLike(1, 2L, 2L);
        System.out.println(aaa);
    }

    @Test
    public void collUpdate() throws Exception{
        System.out.println(collectionAssetService.insertCollection(1, 1L, 1L));

    }

    @Test
    public void collStatus()throws Exception {
        System.out.println(collectionAssetService.selectCollection(1, 1L, 101L));
    }

}
