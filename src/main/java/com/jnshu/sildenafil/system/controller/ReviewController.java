package com.jnshu.sildenafil.system.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jnshu.sildenafil.common.domain.ResponseBo;
import com.jnshu.sildenafil.system.domain.Review;
import com.jnshu.sildenafil.system.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @ProjectName: sildenafil
 * @Package: com.jnshu.sildenafil.system.controller
 * @ClassName: ReviewController
 * @Description: java类作用描述
 * @Author: Taimur
 * @CreateDate: 2018/11/9 18:51
 */
@Controller
public class ReviewController {
    @Autowired
    ReviewService reviewService;
    /**
     *根据学生id获取评论列表（论坛）
     * @param [page, size, student_id]
     * @return  com.jnshu.sildenafil.common.domain.ResponseBo
     */
    @ResponseBody
    @GetMapping(value = "/a/u/front/reviews/student")
    public ResponseBo listByStudent(Integer page,Integer size,Long studentId){
        IPage iPage = reviewService.reviewByStudent(page,size,studentId);
        return ResponseBo.ok().put("reviewList",iPage);
    }
    /**
     *  根据type和typeId获取评论列表
     * @param [page, size, type, typeId]
     * @return  com.jnshu.sildenafil.common.domain.ResponseBo
     */
    @ResponseBody
    @GetMapping(value = "/a/u/common/reviews/type")
    public ResponseBo listByType(Integer page,Integer size ,Integer type,Long typeId){
        IPage iPage = reviewService.reviewByType(page,size,type,typeId);
        return ResponseBo.ok().put("reviewList",iPage);
    }
    /**
     * 新建回复
     * @param [review]
     * @return  com.jnshu.sildenafil.common.domain.ResponseBo
     */
    @ResponseBody
    @PostMapping(value = "/a/u/front/review")
    public ResponseBo addReview(Review review){
        Boolean isSaveReview = reviewService.save(review);
        return ResponseBo.ok().put("isSaveReview",isSaveReview);

    }
    /**
     * 删除回复
     * @param [reviewId]
     * @return  com.jnshu.sildenafil.common.domain.ResponseBo
     */
    @ResponseBody
    @DeleteMapping(value = "/a/u/common/review")
    public ResponseBo deleteReview(Long reviewId){
        Boolean isDeleteReview = reviewService.removeById(reviewId);
        return ResponseBo.ok().put("isDeleteReview",isDeleteReview);
    }
}
