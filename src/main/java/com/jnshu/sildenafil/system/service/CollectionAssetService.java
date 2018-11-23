package com.jnshu.sildenafil.system.service;

import com.jnshu.sildenafil.common.exception.ParamIsNullException;
import com.jnshu.sildenafil.system.domain.CollectionAsset;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lihoo
 * @since 2018-11-11
 */
public interface CollectionAssetService extends IService<CollectionAsset> {

    /**
     * 前台对资料进行点赞
     * @param type 资料类型
     * @param typeId 资料id
     * @param studentId 学生id
     * @return 返回id
     * @throws ParamIsNullException 空参
     */
    Long insertCollection(Integer type,Long typeId,Long studentId) throws ParamIsNullException;

    /**
     * 前台对资料取消点赞
     * @param type 资料类型
     * @param typeId 资料id
     * @param studentId 学生id
     * @return 返回资料id
     * @throws ParamIsNullException 空参
     */
    Long removeCollection(Integer type,Long typeId,Long studentId) throws ParamIsNullException;

    /**
     * 前台查询资料的点赞状态
     * @param type 资料类型
     * @param typeId 资料id
     * @param studentId 学生id
     * @return 0为不赞，1为点赞
     * @throws ParamIsNullException 空参
     */
    int selectCollection(Integer type,Long typeId,Long studentId) throws ParamIsNullException;

    /**
     * 查询学生收藏列表
     * @param type 资料类型
     * @param studentId 学生id
     * @return  java.util.List
     * @throws ParamIsNullException 空参
     */
    List<Long> studentCollection(Integer type,Long studentId) throws ParamIsNullException;
}
