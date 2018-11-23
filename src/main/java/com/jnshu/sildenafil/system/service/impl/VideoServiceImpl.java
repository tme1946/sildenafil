package com.jnshu.sildenafil.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.jnshu.sildenafil.common.exception.ParamIsNullException;
import com.jnshu.sildenafil.common.exception.ServiceException;
import com.jnshu.sildenafil.common.validation.VideoSave;
import com.jnshu.sildenafil.common.validation.VideoUpdate;
import com.jnshu.sildenafil.system.domain.*;
import com.jnshu.sildenafil.system.mapper.TeacherDao;
import com.jnshu.sildenafil.system.mapper.VideoDao;
import com.jnshu.sildenafil.system.service.VideoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jnshu.sildenafil.util.MyPage;
import com.jnshu.sildenafil.util.ValidationUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Taimur
 * @since 2018-10-31
 */
@Service
@Slf4j
public class VideoServiceImpl extends ServiceImpl<VideoDao, Video> implements VideoService {
    private static final long NOW = System.currentTimeMillis();

    private final VideoDao videoDao;
    private final TeacherDao teacherDao;

    @Autowired(required = false)
    public VideoServiceImpl(VideoDao videoDao, TeacherDao teacherDao) {
        this.videoDao = videoDao;
        this.teacherDao = teacherDao;
    }

    /**
     *后台视频列表（分页）
     * @param page 第几页
     * @param size 每页条数
     * @param title 标题
     * @param type 视频类型：0card，1banner
     * @param grade 年级
     * @param subject 科目
     * @param likeStart 点赞数
     * @param likeEnd 点赞数
     * @param collectStart 收藏数
     * @param collectEnd 收藏数
     * @param teacher 老师名
     * @param status 上下架状态
     * @return 视频每页详情
     */
    @Override
    public IPage getPage(Integer page, Integer size, String title, Integer type, Integer grade, Integer subject,
                         Integer likeStart, Integer likeEnd, Integer collectStart, Integer collectEnd,
                         String teacher, Integer status) throws ParamIsNullException {
        log.info("args for getPage is: {}", page, size, title, type, grade, subject,
                                            likeStart, likeEnd, collectStart, collectEnd, teacher, status);
        if (page==null&&size==null) {
            log.error("result for getPage error;page is null,size is null");
            throw new ParamIsNullException("getPage error;args null");
        }
        //调整page和size默认值--
        page= null==page||page<=1 ? 1 : page;
        size= null==size||size<=1||size>20 ? 10 : size;
        IPage<Video> findPage = new MyPage<Video>(page, size).setDesc("update_at");
        QueryWrapper<Video> videoQueryWrapper = new QueryWrapper<>();
        if (teacher != null) {
            QueryWrapper<Teacher> teacherQueryWrapper = new QueryWrapper<>();
            teacherQueryWrapper.select("id").like("nickname", teacher);
            List<Teacher> teacherList = teacherDao.selectList(teacherQueryWrapper);
            List idList = teacherList.stream().map(Teacher::getId).collect(Collectors.toList());
            videoQueryWrapper.in("teacher_id", idList);
        }
        videoQueryWrapper
                    .like(StringUtils.isNotEmpty(title), "title", title)
                    .eq(type != null, "type", type)
                    .eq(grade != null, "grade", grade)
                    .eq(subject != null, "subject", subject)
                    .ge(likeStart != null, "like_amount", likeStart)
                    .le(likeEnd != null, "like_amount", likeEnd)
                    .ge(collectStart != null, "collection_amount", collectStart)
                    .le(collectEnd != null, "collection_amount", collectEnd)
                    .eq(status != null, "status", status);
        IPage videoIPage = videoDao.selectPage(findPage, videoQueryWrapper);
        if (videoIPage.getRecords().size() > 0) {
            log.info("Video size is: {}", videoIPage.getRecords().size());
        } else {
            log.error("List is empty!");
        }
        return videoIPage;
    }

    /**
     * 后台新增视频详情
     * @param video 视频
     * @return 新增视频详情
     */
    @Override
    public Video saveVideo(Video video) throws ServiceException, ParamIsNullException {
        log.info("args for saveVideo is: {}", video);
        if (video == null) {
            log.error("result for saveVideo error;video is null");
            throw new ParamIsNullException("args is null");
        }
        ValidationUtils.validate(video,VideoSave.class);
        video.setCreateAt(NOW);
        video.setUpdateAt(NOW);
        //后台管理员admin
        video.setCreateBy("admin");
        //后台管理员admin
        video.setUpdateBy("admin");
        if (video.getType() == 1) {
            video.setCover(video.getCover());
        } else if (video.getType() == 0) {
            video.setCover(null);
        } else {
            log.info("type false.");
        }
        Long id = videoDao.insert(video) > 0 ? video.getId() : -10000;
        log.info("result for saveVideo success; result detail: videoId={}; {}", id, video);
        return video;
    }

    /**
     *后台更新视频详情
     * @param video 视频
     * @return 更新后视频id
     */
    @Override
    public Long updateVideo(Video video) throws ServiceException, ParamIsNullException {
        log.info("args for updateVideo is: {}", video);
        if (video == null) {
            log.error("result for updateVideo error;video is null");
            throw new ParamIsNullException("args is null");
        }
        Long videoId = video.getId();
        ValidationUtils.validate(video, VideoUpdate.class);
        video.setUpdateAt(NOW);
        //后台管理员userName
        video.setUpdateBy("admin");
        video.setStatus(0);
        if (video.getType() == 1) {
            video.setCover(video.getCover());
        } else if (video.getType() == 0) {
            video.setCover(null);
        } else {
            log.info("illegal type.");
        }
        videoDao.updateById(video);
        return videoId;
    }

    /**
     * 后台更新视频上下架状态
     * @param videoId 视频id
     * @param status 视频上下架状态
     * @return 更新上下架后的视频
     */
    @Override
    public Video updateStatus(Long videoId, Integer status) throws ParamIsNullException {
        log.info("args for updateStatus is: {}", videoId);
        if (videoId==null||status==null) {
            log.error("result for updateStatus error;videoId null, status null");
            throw new ParamIsNullException("args is null");
        }
        Video v = new Video();
        v.setId(videoId);
        v.setStatus(status);
        Long vid = videoDao.updateById(v) > 0 ? v.getId() : -10000;
        log.info("result for updateStatus success; result detail: videoId={}", vid);
        return v;
    }

}
