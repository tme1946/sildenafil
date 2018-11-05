package com.jnshu.sildenafil;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.jnshu.sildenafil.system.domain.Video;
import com.jnshu.sildenafil.system.mapper.TeacherDao;
import com.jnshu.sildenafil.system.mapper.VideoDao;
import com.jnshu.sildenafil.system.service.VideoService;
import com.jnshu.sildenafil.util.MyPage;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * #Title: VideoTest
 * #ProjectName sildenafil
 * #Description: TODO
 * #author lihoo
 * #date 2018/11/3-10:16
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class VideoTest {


    @Autowired
    private VideoDao videoDao;

    @Autowired
    private TeacherDao teacherDao;

    @Autowired
    private VideoService videoService;

    @Test
    public void teacherName() {
        Video video = new Video();
        video.setCreateBy("baolan");
        QueryWrapper<Video> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("create_by", video.getCreateBy());
        Long aaa = videoDao.selectOne(queryWrapper).getTeacherId();
        System.out.println(aaa);
        String teacherName = teacherDao.selectById(aaa).getNickname();
        System.out.println(teacherName);
    }

    @Test
    public void Page() {
        int page = 1;
        int size = 5;
        Video video = new Video();
//        video.setCreateBy("baolan");

        IPage<Video> findPage = new MyPage<Video>(page, size).setDesc("update_at");
//        System.out.println(findPage);
        QueryWrapper<Video> videoQueryWrapper = new QueryWrapper<>();
        videoQueryWrapper.isNotNull("id");

//        if (video != null) {
//            videoQueryWrapper
//                    //标题
//                    .like(StringUtils.isNotEmpty(video.getTitle()), "title", video.getTitle())
//                    //视频类型
//                    .eq(video.getType() != null, "type", video.getType())
//                    //年级
//                    .eq(video.getGrade() != null, "grade", video.getGrade())
//                    //科目
//                    .eq(video.getSubject() != null, "subject", video.getSubject())
//                    //点赞数
//                    .between(video.getLikeAmount() != null, "like_amount", video.getLikeAmount())
//                    //收藏数
//                    .between(video.getCollectionAmount() != null, "collection_amount", video.getCollectionAmount())
////        先查询出老师名称
//                    //老师名称
//                    .like(StringUtils.isNotEmpty(), "nickname", teacherName)
//                    //上下架状态
//                    .eq(video.getStatus() != null, "status", video.getStatus());
//        }

        IPage<Video> aaa = videoDao.selectPage(findPage, videoQueryWrapper);
        aaa.getRecords().forEach(System.out::println);


    }

    @Test
    public void addVideo() {
        Video v = new Video();
        v.setGrade(4);
        v.setSubject(7);
        //传入老师id,返回老师名和头像
        v.setTeacherId(2L);
        v.setTitle("testTitle");
        //是card还是banner
        v.setType(1);
        //        //判断是banner还是card
        v.setCover("testcoverrrrrr");
        v.setDigest("testDigest");
        v.setUrl("testUrl");
        v.setBody("testBody");

        System.out.println(videoService.saveVideo(v));
//        Long now = System.currentTimeMillis();
//        Video v = new Video();
//        v.setCreateAt(now);
//        v.setUpdateAt(now);
//        v.setCreateBy("lihoo");
//        v.setUpdateBy("lihoo");
//        v.setTeacherId(1L);
//        v.setUrl("testUrl");
//        v.setBody("testBody");
//        v.setType(1);
//        v.setCover("testCover");
//        v.setGrade(1);
//        v.setSubject(9);
//        v.setDigest("testDigest");
//        v.setTitle("testTitle");
//        v.setStatus(0);
//        int newVideo = videoDao.insert(v);
//        System.out.println(newVideo);
    }


    @Test
    public void testGetVideoPage() {

        IPage aaaa = videoService
                .getPage(1,5, null, null, null, null,
                        1, null, 1, null,
                        null,1);
        aaaa.getRecords().forEach(System.out::println);


    }
}
