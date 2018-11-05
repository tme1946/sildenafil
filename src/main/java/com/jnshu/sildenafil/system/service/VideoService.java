package com.jnshu.sildenafil.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jnshu.sildenafil.system.domain.Video;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lihoo
 * @since 2018-11-03
 */
@SuppressWarnings("unused")
public interface VideoService extends IService<Video> {

    /**
     * 前后台查询视频列表（分页）
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
     * @return 分页后的视频List
     */
    IPage getPage(Integer page, Integer size, String title, Integer type, Integer grade, Integer subject,
                  Integer likeStart, Integer likeEnd, Integer collectStart, Integer collectEnd,
                  String teacher, Integer status);

    /**
     * 前台查询视频详情
     * @param videoId 视频id
     * @return 增加的视频详情
     */
    Video getVideoById(Long videoId);

    /**
     * 后台新增视频
     * @param video 视频
     * @return 新增加的视频
     */
    Video saveVideo(Video video);

    /**
     * 后台删除视频
     * @param videoId 视频id
     * @return 是否成功删除视频
     */
    Boolean removeVideoById(Long videoId);

    /**
     * 后台修改视频详情
     * @param video 视频
     * @return 更新后的视频id
     */
    Long updateVideo(Video video);

}
