package com.jnshu.sildenafil.system.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jnshu.sildenafil.common.domain.ResponseBo;
import com.jnshu.sildenafil.system.domain.Review;
import com.jnshu.sildenafil.system.service.ReviewService;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@Controller
public class ReviewController {
    @Autowired
    ReviewService reviewService;
    /**
     *  根据type和typeId获取评论列表（单体查询）
     * @param [page, size, type, typeId]
     * @return  com.jnshu.sildenafil.common.domain.ResponseBo
     */
    @ResponseBody
    @GetMapping(value = "/a/u/admin/reviews/type")
    public ResponseBo listByType(Integer page,Integer size ,Integer type,Long typeId){
        log.info("args for type,typeId is: type={},typeId{}",type,typeId);
        if(type == null){
            log.error("args for type is null");
            return ResponseBo.error("type is null");}
        if(typeId == null){
            log.error("args for typeId is null");
            return ResponseBo.error("typeId is null");}
        IPage iPage = reviewService.reviewByType(page,size,type,typeId);
        log.info("result for reviewListSize is : Size={}",iPage.getSize());
        return ResponseBo.ok().put("data",iPage);
    }
    /**
     * 删除回复（主键）
     * @param [reviewId]
     * @return  com.jnshu.sildenafil.common.domain.ResponseBo
     */
    @ResponseBody
    @DeleteMapping(value = "/a/u/admin/review")
    public ResponseBo deleteReview(Long reviewId){
        log.info("args for deleteReviewId is : reviewId={}",reviewId);
        if(reviewId==null){
            log.error("args for reviewId is null");
            return ResponseBo.error("ReviewId is null"); }
        if(reviewService.removeById(reviewId)){
            log.info("result for deleteReviewId is : reviewId={}",reviewId);
            return ResponseBo.ok();
        }else{
            log.error("deleteReview error");
            return ResponseBo.error("delete error");
        }
    }
}
