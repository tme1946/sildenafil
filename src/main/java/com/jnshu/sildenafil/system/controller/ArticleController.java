package com.jnshu.sildenafil.system.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.jnshu.sildenafil.common.domain.ResponseBo;
import com.jnshu.sildenafil.system.domain.Article;
import com.jnshu.sildenafil.system.service.ArticleService;
import com.jnshu.sildenafil.util.MyPage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * @author feifei 假数据
 */
@Slf4j
@Controller
public class ArticleController {
    @Autowired
    ArticleService articleService;

    /** 后台根据条件分页查询文章
     * @param page 页码
     * @param size 数量
     * @param title 标题
     * @param author 作者
     * @param type 类型
     * @param status 状态
     * @param likeStart 点赞下限
     * @param likeEnd 点赞上限
     * @param collectionStart 收藏下限
     * @param collectionEnd 收藏上限
     * @return 文章list和分页信息
     */
    @ResponseBody
    @PreAuthorize("hasAuthority('artilce:list')")
    @GetMapping(value = "/a/u/admin/article/list")
    public ResponseBo getArticleList(Integer page, Integer size,String title,String author,
                                  Integer type,Integer status,Integer likeStart,Integer likeEnd,
                                  Integer collectionStart,Integer collectionEnd) {
        log.info("args for getArticlePageList is:*** page={}&size={}&title={}&author={}&type={}" +
                        "&status={}&likeStart={}&likeEnd={}&collectionStart={}&collectionEnd={} ***"
                , page, size, title, author, type, status, likeStart, likeEnd, collectionStart, collectionEnd);
        //真参数
        IPage articleList=articleService.getAdminPageList(page,size,title,author,type,status,
                likeStart,likeEnd,collectionStart,collectionEnd);
        if(articleList!=null){
            return ResponseBo.ok().put("articleList",articleList);
        }
        return ResponseBo.error("请求错误");
    }

    /**后台根据文章id查询文章详情
     * @param articleId 文章id
     * @return 文章内容
     */
    @ResponseBody
    @PreAuthorize("hasAuthority('artilce:list')")
    @GetMapping(value = "/a/u/admin/article")
    public ResponseBo getArticleByArticleId(Long articleId){
        log.info("args for getArticleByArticleId : articleId={}",articleId);
        //真数据
        Article article=articleService.getArticleById(articleId);
        if(article!=null){
            log.info("result for getArticleByArticleId : article={}",article);
            return ResponseBo.ok("操作成功").put("article",article);
        }
        return ResponseBo.error("请求错误");
    }

    /**后台增加文章
     * @param article 文章信息
     * @return 状态
     */
    @ResponseBody
    @PreAuthorize("hasAuthority('artilce:save')")
    @PostMapping(value = "/a/u/admin/article")
    public ResponseBo saveArticle(Article article) {
        log.info("args for saveArticle is:*** article=[{}] ***"
                , article);
        Article article2=articleService.saveArticle(article);
        if(article2!=null){
            return ResponseBo.ok("操作成功");
        }
        return ResponseBo.error("请求错误");
    }

    /**后台更改文章信息
     * @param article 待更新信息
     * @return 成功后返回修改的记录的id
     */
    @ResponseBody
    @PreAuthorize("hasAuthority('artilce:update')")
    @PutMapping(value = "/a/u/admin/article")
    public ResponseBo updateArticleById(Article article) {
        log.info("args for updateArticleById is:*** article=[{}] ***"
                , article);
        Long articleId=articleService.updateArticle(article);
        if(articleId!=null){
            return ResponseBo.ok("操作成功");
        }
        return ResponseBo.error("请求错误");
    }

    /**后台更改文章状态
     * @param articleId 文章id
     * @param status 修改后的状态值
     * @param type 文章的类型
     * @return 成功后返回修改的记录的id
     */
    @ResponseBody
    @PreAuthorize("hasAuthority('artilce:list')")
    @PutMapping(value = "/a/u/admin/article/status")
    public ResponseBo updateArticleStatus(Long articleId,Integer type,Integer status) {
        log.info("args for updateArticleStatus: articleId=[{}]&type=[{}]&status=[{}]",articleId,type,status);
        Long articleId2=articleService.updateArticleStatus(articleId,type,status);
        if(articleId2!=null){
            return ResponseBo.ok("操作成功");
        }
        return ResponseBo.error("请求错误");
    }

}
