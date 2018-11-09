package com.jnshu.sildenafil.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jnshu.sildenafil.system.domain.Review;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Taimur
 * @since 2018-10-31
 */
public interface ReviewService extends IService<Review> {
    /**
     * 根据学生id获取该学生的所有回复（帖子）
     * @param [page, size, studentId]
     * @return  com.baomidou.mybatisplus.core.metadata.IPage
     */
    IPage reviewByStudent(Integer page, Integer size,Long studentId);
    /**
     * 根据type和type_id 获取回复列表
     * @param [page, size, type, typeId]
     * @return  com.baomidou.mybatisplus.core.metadata.IPage
     */
    IPage reviewByType(Integer page,Integer size,Integer type,Long typeId);
}
