package com.jnshu.sildenafil.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jnshu.sildenafil.system.domain.Review;
import com.jnshu.sildenafil.system.mapper.ReviewDao;
import com.jnshu.sildenafil.system.service.ReviewService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jnshu.sildenafil.util.MyPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Taimur
 * @since 2018-10-31
 */
@Service
public class ReviewServiceImpl extends ServiceImpl<ReviewDao, Review> implements ReviewService {
    @Autowired
    ReviewDao reviewDao;

    @Override
    public IPage reviewByType(Integer page,Integer size,Integer type,Long typeId){
        page= null==page||page<=1 ? 1 : page;
        size= null==size||size<=1||size>20 ? 10 : size;
        IPage<Review> iPage = new MyPage<>(page,size);
        QueryWrapper<Review> wrapper = new QueryWrapper<>();
        wrapper.eq("type",type);
        wrapper.eq("type_id",typeId);
        wrapper.orderByDesc("create_at");
        return reviewDao.selectPage(iPage,wrapper);
    }
}
