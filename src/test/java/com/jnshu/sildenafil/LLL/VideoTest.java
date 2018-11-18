package com.jnshu.sildenafil.LLL;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jnshu.sildenafil.common.exception.ParamIsNullException;
import com.jnshu.sildenafil.common.exception.ServiceException;
import com.jnshu.sildenafil.system.domain.LikeAsset;
import com.jnshu.sildenafil.system.domain.Teacher;
import com.jnshu.sildenafil.system.domain.Video;
import com.jnshu.sildenafil.system.mapper.LikeAssetDao;
import com.jnshu.sildenafil.system.mapper.TeacherDao;
import com.jnshu.sildenafil.system.mapper.VideoDao;
import com.jnshu.sildenafil.system.service.TeacherService;
import com.jnshu.sildenafil.system.service.VideoService;
import com.jnshu.sildenafil.util.MyPage;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
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

    @Autowired
    private TeacherService teacherService;

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
        v.setGrade(1);
        v.setSubject(1);
        //传入老师id,返回老师名和头像
        v.setTeacherId(4L);
        v.setTitle("黑人问号的由来");
        //是0card还是1banner
        v.setType(1);
        //判断是banner还是card
        v.setCover("https:nichoushaaaaaa!!!!");
        v.setDigest("nba 球员的黑历史");
        v.setUrl("http:www.nba.com");
        v.setTimeLength("50:17");
        v.setBody("qwertyuiopasdfghjklxcvbgnhdfghjk42310.98652798+5643121000054231131");

//        System.out.println(videoService.saveVideo(v));
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
                        null, null, null, null,
                        "尼",null);
        aaaa.getRecords().forEach(System.out::println);


    }

    @Test
    public void updateVideo() {
        Video v = new Video();
        v.setId(10L);
        v.setGrade(6);
        v.setSubject(6);
        v.setTeacherId(6L);
        v.setTitle("6");
        v.setType(0);
        v.setCover("6");
        v.setDigest("6");
        v.setUrl("6");
        v.setBody("6");

        try{
            videoService.updateVideo(new Video());
        }catch(ServiceException se){
            System.out.println("JB" + se.getMessage());
        }catch (ParamIsNullException pa){
            log.error("paramnull{}",pa.getMessage());

        }

    }

    @Test
    public void update() {
        Video v = new Video();
        v.setId(11L);
        v.setGrade(2);
        v.setSubject(2);
        v.setTeacherId(2L);
        v.setTitle("2");
        v.setType(0);
        v.setCover("2");
        v.setDigest("2");
        v.setUrl("2");
        v.setBody("2");
//        Long aaaa = videoService.updateVideo(v);
//        System.out.println(aaaa);

    }

//    @Test
//    public void getVById() {
//        Long id = 50L;
//        Video v = videoService.getVideoById(id, 1L);
////        System.out.println(v.getGrade());
////        System.out.println(v.getSubject());
//        System.out.println(v.getTitle());
//        System.out.println(v.getUpdateAt());
//        String tname = teacherService.getTeacherById(v.getTeacherId()).getNickname();
//        System.out.println(tname);
////        封装一个通过videoId来查询老师名的
//
//
////        System.out.println(v.getType());//判断是card还是banner，进入视频详情还用分banner和card？？？
////        System.out.println(v.getCover());
//        System.out.println(v.getDigest());
//        System.out.println(v.getUrl());
//        System.out.println(v.getTimeLength());
//        System.out.println(v.getBody());
//        System.out.println(v.getLikeAmount());
//        System.out.println(v.getCollectionAmount());
//    }

    @Test
    public void idToNickname() {
        Long tid = 2L;
        QueryWrapper<Teacher> tqw = new QueryWrapper<>();
        tqw.select("nickname").eq("id", tid);
        Teacher teacherbenren = teacherDao.selectOne(tqw);
        System.out.println(teacherbenren);
        System.out.println(teacherbenren.getNickname());

        List nameList = new ArrayList<>();
        nameList.add(teacherbenren);
//        System.out.println(nameList);
//        tqw.in("teacher_id", nameList);
    }

//    @Test
//    public void deleteVideo() {
//        Boolean aaa = videoService.removeVideoById(52L);
//        System.out.println(aaa);
//    }

    @Test
    public void getTimeLength() {
        System.out.println(videoDao.selectById(1L).getTimeLength());
    }

    @Test
    public void BatchTimeLength() {
//        videoDao.update()

    }

    @Test
    public void updateStatus() {
        Video vvv =  videoService.updateStatus(71L, 1);
        System.out.println(vvv.getStatus());
    }

    @Autowired
    private LikeAssetDao likeAssetDao;

    @Test
    public void updateLike() {
//        Long videoId = 2L;
//        System.out.println(videoService.updateLikeAmount(videoId));
    }

    @Test
    public void delete() {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("student_id", 1);
        queryWrapper.eq("type_id", 2);
        System.out.println(likeAssetDao.delete(queryWrapper));
    }
}
