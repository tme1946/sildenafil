package com.jnshu.sildenafil.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jnshu.sildenafil.system.domain.LikeAsset;
import com.jnshu.sildenafil.system.mapper.LikeAssetDao;
import com.jnshu.sildenafil.system.service.LikeAssetService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lihoo
 * @since 2018-11-10
 */
@Slf4j
@Service
public class LikeAssetServiceImpl extends ServiceImpl<LikeAssetDao, LikeAsset> implements LikeAssetService {
    private static final long NOW = System.currentTimeMillis();

    private final LikeAssetDao likeAssetDao;

    @Autowired
    public LikeAssetServiceImpl(LikeAssetDao likeAssetDao) {
        this.likeAssetDao = likeAssetDao;
    }

    /**
     * 前台对文章进行点赞
     * @param type 资料类型
     * @param typeId 资料id
     * @param studentId 学生id
     * @return 返回点赞的结果
     */
    @Override
    public Long insertLike(Integer type, Long typeId, Long studentId){
        log.info("args for insertLike is : type={}&typeId={}&studentId={}&",type,typeId,studentId);
        QueryWrapper<LikeAsset> likeAssetQueryWrapper = new QueryWrapper<>();
        likeAssetQueryWrapper
                .eq("type_id", typeId)
                .eq("student_id", studentId)
                .eq("type", type);
        likeAssetDao.delete(likeAssetQueryWrapper);
        LikeAsset newLike = new LikeAsset();
        newLike.setCreateAt(NOW);
        newLike.setUpdateAt(NOW);
        newLike.setType(type);
        newLike.setTypeId(typeId);
        newLike.setStudentId(studentId);
        Long likeId = likeAssetDao.insert(newLike) > 0 ? newLike.getId() : -10000;
        log.info("result for insertLike success; result detail: likeId={}", likeId);
        return likeId;
    }

    /**
     * 前台查询资料的点赞状态
     * @param type 资料类型
     * @param typeId 资料id
     * @param studentId 学生id
     * @return 0为不赞，1为点赞
     */
    @Override
    public int selectLike(Integer type, Long typeId, Long studentId){
        log.info("args for insertLike is : type={}&typeId={}&studentId={}&",type,typeId,studentId);
        QueryWrapper<LikeAsset> likeAssetQueryWrapper = new QueryWrapper<>();
        likeAssetQueryWrapper
                .eq("type_id", typeId)
                .eq("student_id", studentId)
                .eq("type", type);
        LikeAsset likeAsset = likeAssetDao.selectOne(likeAssetQueryWrapper);
        if (likeAsset != null) {
            log.info("you liked");
            return 1;
        } else {
            log.info("not like");
            return 0;
        }
    }
}
