package com.jnshu.sildenafil.system.service.impl;

import com.jnshu.sildenafil.system.domain.LikeAsset;
import com.jnshu.sildenafil.system.mapper.LikeAssetDao;
import com.jnshu.sildenafil.system.service.LikeAssetService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Taimur
 * @since 2018-10-31
 */
@Slf4j
@Service
public class LikeAssetServiceImpl extends ServiceImpl<LikeAssetDao, LikeAsset> implements LikeAssetService {

    /**前台对文章进行点赞
     * @param type 资料类型
     * @param typeId 资料id
     * @param studentId 学生id
     * @return 返回点赞的结果
     */
    @Override
    public Long insertLike(Integer type, Long typeId, Long studentId){
        log.info("args for insertLike is : type={}&typeId={}&studentId={}&",type,typeId,studentId);
        return null;
    }

    /**前台查询资料的点赞状态
     * @param type 资料类型
     * @param typeId 资料id
     * @param studentId 学生id
     * @return 0为不赞，1为点赞
     */
    @Override
    public Long selectLike(Integer type,Long typeId,Long studentId){
        return null;
    }
}
