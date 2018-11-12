package com.jnshu.sildenafil.system.controller;

import com.jnshu.sildenafil.common.domain.ResponseBo;
import com.jnshu.sildenafil.system.domain.Article;
import com.jnshu.sildenafil.system.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ProjectName: sildenafil
 * @Package: com.jnshu.sildenafil.system.controller
 * @ClassName: StudentController
 * @Description: java类作用描述
 * @Author: feifei
 * @CreateDate: 2018/11/9 15:23
 */
@Slf4j
@Controller
public class ArticleController {
    @Autowired
    ArticleService articleService;

    /**前台根据文章id查询文章详情
     * @param studentId 学生id
     * @param articleId 文章id
     * @return 文章内容
     */
    @ResponseBody
    @GetMapping(value = "/a/u/front/article/{studentId}{articleId}")
    public ResponseBo getArticleByArticleId(@PathVariable Long studentId,@PathVariable Long articleId){
        log.info("args for getArticleByArticleId is : articleId={}",articleId);
        if(articleId==null){
            log.error("result for getArticleByArticleId error :***articleId null***");
            return ResponseBo.error("article is null");
        }
        Article article=articleService.getArticleById(articleId);
        log.info("result for getArticleByArticleId is : article={}",article);
        return ResponseBo.ok().put("article",article);
    }
}
