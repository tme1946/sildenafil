package com.jnshu.sildenafil.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jnshu.sildenafil.system.domain.Video;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jnshu.sildenafil.common.exception.ParamIsNullException;
import com.jnshu.sildenafil.common.exception.ServiceException;



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
     * 后台查询视频列表（分页）
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
     * @throws ParamIsNullException 空参
     */
    IPage getPage(Integer page, Integer size, String title, Integer type, Integer grade, Integer subject,
                  Integer likeStart, Integer likeEnd, Integer collectStart, Integer collectEnd,
                  String teacher, Integer status) throws ParamIsNullException;


    /**
     * 后台新增视频
     * @param video 视频
     * @return 新增加的视频
     * @throws ServiceException service错误
     * @throws ParamIsNullException 参数为空
     */
    Video saveVideo(Video video) throws ServiceException, ParamIsNullException;

    /**
     * 后台修改视频详情
     * @param video 视频
     * @return 更新后的视频id
     * @throws ServiceException service错误
     * @throws ParamIsNullException 参数为空
     */
    Long updateVideo(Video video) throws ServiceException, ParamIsNullException;

    /**
     * 后台更新视频上下架状态
     * @param videoId 视频id
     * @param status 视频上下架状态
     * @return 更新上下架后的视频
     * @throws ParamIsNullException 空参
     */
    Video updateStatus(Long videoId, Integer status) throws ParamIsNullException;
}
