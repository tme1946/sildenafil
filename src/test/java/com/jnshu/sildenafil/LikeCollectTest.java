package com.jnshu.sildenafil;

import com.jnshu.sildenafil.system.service.LikeAssetService;
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
    private LikeAssetService likeAssetService;

    @Test
    public void like() {
        Long aaa = likeAssetService.insertLike(1, 1L, 1L);
        System.out.println(aaa);
    }

    @Test
    public void likeStatus() {
        int aaa =  likeAssetService.selectLike(1, 50L, 10L);
        System.out.println(aaa);
    }
}
