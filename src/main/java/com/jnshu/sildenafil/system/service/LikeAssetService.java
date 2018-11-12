package com.jnshu.sildenafil.system.service;

import com.jnshu.sildenafil.system.domain.LikeAsset;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lihoo
 * @since 2018-11-11
 */
public interface LikeAssetService extends IService<LikeAsset> {

    /**
     * 前台对资料进行点赞
     * @param type 资料类型
     * @param typeId 资料id
     * @param studentId 学生id
     * @return 返回点赞的结果
     */
    Long insertLike(Integer type,Long typeId,Long studentId);

    /**
     * 前台查询资料的点赞状态
     * @param type 资料类型
     * @param typeId 资料id
     * @param studentId 学生id
     * @return 0为不赞，1为点赞
     */
    int selectLike(Integer type,Long typeId,Long studentId);
}
