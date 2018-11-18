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
     * @return 文章list
     */
    @ResponseBody
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
        if(articleList==null){
            return ResponseBo.error("参数异常或结果为空");
        }
        return ResponseBo.ok().put("data",articleList);
    }

    /**后台根据文章id查询文章详情
     * @param studentId 学生id
     * @param articleId 文章id
     * @return 文章内容
     */
    @ResponseBody
    @GetMapping(value = "/a/u/admin/article")
    public ResponseBo getArticleByArticleId( Long studentId, Long articleId){
        log.info("args for getArticleByArticleId : articleId={}",articleId);
        if(articleId==null){
            log.warn("result for getArticleByArticleId error :***articleId null***");
            return ResponseBo.error("假数据参数异常");
        }
        //真数据
//        Article article=articleService.getArticleById(articleId);
        //假数据
        Article article=new Article();
        article.setId(articleId);
        article.setCreateAt(System.currentTimeMillis());
        article.setCreateBy("假数据创建人");
        article.setUpdateAt(System.currentTimeMillis());
        article.setUpdateBy("假数据更新人");
        article.setTitle("假数据标题");
        article.setAuthor("假数据作者");
        article.setDigest("假数据摘要");
        article.setBody("假数据正文");
        article.setCover("https://www.google.com/url?sa=i&source=images&cd=&cad=rja&uact=8&ved=2ahUKEwikyK_ahNbeAhUZITQIHbRYC6EQjRx6BAgBEAU&url=https%3A%2F%2Fbaike.baidu.com%2Fitem%2F%25E5%2591%25B5%25E5%2591%25B5%2F34431&psig=AOvVaw2JVJ7IJs9JiM8faqiCpdbt&ust=1542358865301283");
        article.setLikeAmount(1000);
        article.setCollectionAmount(2000);
        article.setStatus(1);
        log.info("result for getArticleByArticleId : article={}",article);
        return ResponseBo.ok("接口同了哟").put("article",article);
    }

    /**后台增加文章
     * @param article 文章信息
     * @return 状态
     */
    @ResponseBody
    @PostMapping(value = "/a/u/admin/article")
    public ResponseBo saveArticle(Article article) {
        log.info("args for saveArticle is:*** article=[{}] ***"
                , article);
/*        Article article2=articleService.saveArticle(article);
        if(article2==null){
            return ResponseBo.error("参数异常");
        }*/
        if(article==null){
            return ResponseBo.error("假数据参数异常");
        }
        return ResponseBo.ok("接口同了哟");
    }

    /**后台更改文章信息
     * @param article 待更新信息
     * @return 成功后返回修改的记录的id
     */
    @ResponseBody
    @PutMapping(value = "/a/u/admin/article")
    public ResponseBo updateArticleById(Article article) {
/*        log.info("args for updateArticleById is:*** article=[{}] ***"
                , article);
        Long articleId=articleService.updateArticle(article);
        if(articleId==null){
            return ResponseBo.error("参数异常");
        }*/
        if(article==null){
            return ResponseBo.error("假数据参数异常");
        }
        return ResponseBo.ok("接口同了哟");
    }

    /**后台更改文章状态
     * @param articleId 文章id
     * @param status 修改后的状态值
     * @param type 文章的类型
     * @return 成功后返回修改的记录的id
     */
    @ResponseBody
    @PutMapping(value = "/a/u/admin/article/status")
    public ResponseBo updateArticleStatus(Long articleId,Integer type,Integer status) {
/*        log.info("args for updateArticleStatus: articleId={}&type={}&status={}",articleId,type,status);
        Long articleId2=articleService.updateArticleStatus(articleId,type,status);
        if(articleId2==null){
            return ResponseBo.error("参数异常");
        }*/
        if(null==articleId||null==type||null==status){
            return ResponseBo.error("假数据参数异常");
        }
        return ResponseBo.ok("接口同了哟");
    }

}
