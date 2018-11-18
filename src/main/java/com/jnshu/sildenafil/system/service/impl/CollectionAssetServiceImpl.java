package com.jnshu.sildenafil.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jnshu.sildenafil.system.domain.CollectionAsset;
import com.jnshu.sildenafil.system.mapper.CollectionAssetDao;
import com.jnshu.sildenafil.system.service.CollectionAssetService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
 * @author lihoo
 * @since 2018-11-11
 */
@Service
@Slf4j
public class CollectionAssetServiceImpl extends ServiceImpl<CollectionAssetDao, CollectionAsset> implements CollectionAssetService {
    private static final long NOW = System.currentTimeMillis();

    private final CollectionAssetDao collectionAssetDao;

    @Autowired
    public CollectionAssetServiceImpl(CollectionAssetDao collectionAssetDao) {
        this.collectionAssetDao = collectionAssetDao;
    }

    /**
     * 前台对资料进行点赞
     *
     * @param type      资料类型
     * @param typeId    资料id
     * @param studentId 学生id
     * @return 返回点赞的结果
     */
    @Override
    public Long insertCollection(Integer type, Long typeId, Long studentId) {
        log.info("args for insertCollection is : type={}&typeId={}&studentId={}&", type, typeId, studentId);
        QueryWrapper<CollectionAsset> collectionAssetQueryWrapper = new QueryWrapper<>();
        collectionAssetQueryWrapper
                .eq("type_id", typeId)
                .eq("student_id", studentId)
                .eq("type", type);
        collectionAssetDao.delete(collectionAssetQueryWrapper);
        CollectionAsset newColl = new CollectionAsset();
        newColl.setCreateAt(NOW);
        newColl.setUpdateAt(NOW);
        newColl.setType(type);
        newColl.setTypeId(typeId);
        newColl.setStudentId(studentId);
        Long collId = collectionAssetDao.insert(newColl) > 0 ? newColl.getId() : -10000;
        log.info("result for insertCollection success; result detail: collId={}", collId);
        return collId;
    }

    /**
     * 前台对资料取消点赞
     * @param type 资料类型
     * @param typeId 资料id
     * @param studentId 学生id
     * @return 返回资料id
     */
    @Override
    public Long removeCollection(Integer type, Long typeId, Long studentId) {
        log.info("args for removeCollection is : type={}&typeId={}&studentId={}&", type, typeId, studentId);
        QueryWrapper<CollectionAsset> collectionAssetQueryWrapper = new QueryWrapper<>();
        collectionAssetQueryWrapper
                .eq("type_id", typeId)
                .eq("student_id", studentId)
                .eq("type", type);
        Long id = collectionAssetDao.delete(collectionAssetQueryWrapper) > 0 ? typeId : -10000;
        log.info("result for removeCollection success; result detail: id={}", id);
        return id;
    }

    /**
     * 前台查询资料的点赞状态
     *
     * @param type      资料类型
     * @param typeId    资料id
     * @param studentId 学生id
     * @return 0为不赞，1为点赞
     */
    @Override
    public int selectCollection(Integer type, Long typeId, Long studentId) {
        log.info("args for selectCollection is : type={}&typeId={}&studentId={}&", type, typeId, studentId);
        QueryWrapper<CollectionAsset> collectionAssetQueryWrapper = new QueryWrapper<>();
        collectionAssetQueryWrapper
                .eq("type_id", typeId)
                .eq("student_id", studentId)
                .eq("type", type);
        CollectionAsset collAsset = collectionAssetDao.selectOne(collectionAssetQueryWrapper);
        if (collAsset != null) {
            log.info("you collected");
            return 1;
        } else {
            log.info("not collect");
            return 0;
        }
    }

    @Override
    public List<Long> studentCollection(Integer type, Long studentId) {
        QueryWrapper<CollectionAsset> wrapper = new QueryWrapper<>();
        wrapper.eq("student_id", studentId)
                .eq("type", type)
                .select("type_id").orderByDesc("update_at");
        List<CollectionAsset> collectionList =collectionAssetDao.selectList(wrapper);
        List<Long> idList = collectionList.stream().map(CollectionAsset::getTypeId).collect(Collectors.toList());
        return idList;
    }

}
