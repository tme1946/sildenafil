package com.jnshu.sildenafil.system.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jnshu.sildenafil.common.exception.ServiceException;

import com.jnshu.sildenafil.common.validation.ArticleSave;
import com.jnshu.sildenafil.common.validation.ArticleUpdate;

import com.jnshu.sildenafil.system.domain.Article;
import com.jnshu.sildenafil.system.mapper.ArticleDao;
import com.jnshu.sildenafil.system.service.ArticleService;
import com.jnshu.sildenafil.util.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *TODO
 * @author feifei
 * @since 2018-10-30
 */
@Slf4j
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleDao, Article> implements ArticleService {

    @Autowired(required = false)
    private ArticleDao articleDao;


    /**前台分页查询card文章信息
     * @param page 页码
     * @param size 每页数量
     * @return 文章列表
     */
    @Override
    public IPage getFrontCardPageList(Integer page, Integer size){
        log.info("args for getFrontPageList is : page={}&size={}",page,size);
        //调整page和size默认值--
        page= null==page||page<=1 ? 1 : page;
        size= null==size||size<=1||size>20 ? 10 : size;
        IPage<Article> pageQuery=new MyPage<Article>(page,size).setDesc("update_at");
        //构建条件查询语句
        QueryWrapper<Article> queryWrapper=new QueryWrapper<>();
        queryWrapper.select("id","type","title","author","cover","digest","like_amount","collection_amount","create_at")
                    .eq("type",0)
                    .eq("status",1);
        IPage articleCardIPage=articleDao.selectPage( pageQuery,queryWrapper);
        if(articleCardIPage.getRecords().size()>0)
        {
            log.info("result for getFrontCardPageList's size is {}",articleCardIPage.getRecords().size());
            return articleCardIPage;
        } else{
            log.error("result for getFrontCardPageList error :***reason is list null***");
            return null;
        }
    }

    /**前台分页查询banner文章信息
     * @param page 页码
     * @param size 每页数量
     * @return 文章列表
     */
    @Override
    public IPage getFrontBannerPageList(Integer page, Integer size){
        log.info("args for getFrontPageList is : page={}&size={}",page,size);
        //调整page和size默认值--
        page= null==page||page<=1? 1 : page;
        size= null==size||size<=1||size>20 ? 10 : size;
        IPage<Article> pageQuery=new MyPage<Article>(page,size).setDesc("update_at");
        //构建条件查询语句
        QueryWrapper<Article> queryWrapper=new QueryWrapper<>();
        queryWrapper.select("id","type","title","author","cover","digest","like_amount","collection_amount","create_at")
                .eq("type",1)
                .eq("status",1);
        IPage articleBannerIPage=articleDao.selectPage( pageQuery,queryWrapper);
        if(articleBannerIPage.getRecords().size()>0)
        {
            log.info("result for getFrontBannerPageList's size is {}",articleBannerIPage.getRecords().size());
            return articleBannerIPage;
        } else{
            log.error("result for getFrontBannerPageList error :***reason is list null***");
            return null;
        }
    }

    /**前台根据文章id查询文章信息
     * @param articleId 文章id
     * @return 对应文章
     */
    @Override
    public  Article getArticleById(Long articleId) {
        log.info("args for getArticleById is : articleId={}",articleId);
        if (null != articleId) {
            //构建条件查询语句
            QueryWrapper<Article> queryWrapper=new QueryWrapper<>();
            queryWrapper.select("id","type","title","author","cover","body","like_amount","collection_amount","create_at")
                        .eq("id",articleId);
            Article article=articleDao.selectOne(queryWrapper);
            log.info("result for getArticleById is :{}",article);
            return article;
        }else{
            log.error("result for getArticleById is error;reason :args is null");
            return null;
        }
    }

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
    @Override
    public IPage getAdminPageList(Integer page, Integer size,String title,String author,
                                  Integer type,Integer status,Integer likeStart,Integer likeEnd,
                                  Integer collectionStart,Integer collectionEnd){
        log.info("args for getArticlePageList is:*** page={}&size={}&title={}&author={}&type={}" +
                        "&status={}&likeStart={}&likeEnd={}&collectionStart={}&collectionEnd={} ***"
                ,page,size,title,author,type,status,likeStart,likeEnd,collectionStart,collectionEnd);
        //调整page和size默认值--
        page= null==page||page<=1? 1 : page;
        size= null==size||size<=1||size>20 ? 10 : size;
        IPage<Article> pageQuery=new MyPage<Article>(page,size).setDesc("update_at");
        //构建条件查询语句
        QueryWrapper<Article> queryWrapper=new QueryWrapper<>();
        queryWrapper
                .select("id","type","title","author","cover","digest","like_amount","collection_amount","update_at")
                .like(StringUtils.isNotEmpty(title), "title", title)
                .like(StringUtils.isNotEmpty(author), "author", author)
                .eq(null != type, "type", type)
                .eq(null != status, "status", status)
                .ge(null !=likeStart,"like_amount",likeStart)
                .le(null !=likeEnd,"like_amount",likeEnd)
                .ge(null !=collectionStart,"collection_amount",collectionStart)
                .le(null !=collectionEnd,"collection_amount",collectionEnd)
        ;
        IPage articleIPage=articleDao.selectPage( pageQuery,queryWrapper);
        if(articleIPage.getRecords().size()>0)
        {
            log.info("result for pageArticleList's size is {}",articleIPage.getRecords().size());
            return articleIPage;
        } else{
            log.error("result for pageArticleList error :***reason is list null***");
            return null;
        }
    }

    /**后台保存文章
     * @param article 文章信息
     * @return 插入后的article
     */
    @Override
    public Article saveArticle(Article article) {
        log.info("args for saveArticle is: {}",article);
        //参数验证，验证必要的参数是否填了；
        try{
            //使用save验证组对参数进行验证
            ValidationUtils.validate(article,ArticleSave.class);
            article.setCreateAt(System.currentTimeMillis());
            article.setUpdateAt(System.currentTimeMillis());
            article.setCreateBy("studentId:"+article.getId());
            article.setUpdateBy("studentId:"+article.getId());
            long l= articleDao.insert(article)>0 ? article.getId() : -3002;
            log.info("result for saveArticle success;result detail: articleId={};{}",l,article);
            return article;
        }catch(ServiceException se){
          log.error("result for saveArticle error;reason is args error;detail exception is:{}",
                  se.getMessage());
          return null;
        }catch(IllegalArgumentException iae) {
            //article为null
            log.error("result for saveArticle error;reason is article null error;detail exception is:{}",(Object)iae.getStackTrace());
            return null;
        }
    }

    /**后台更改文章信息
     * @param article 待更新信息
     * @return 成功后返回修改的记录的id
     */
    @Override
    public Long updateArticle(Article article) {
        log.info("updateArticle's args is {}",article);
        //参数验证
        try {
            //使用update验证组对参数进行验证
            ValidationUtils.validate(article,ArticleUpdate.class);
            article.setUpdateAt(System.currentTimeMillis());
            //设置更改人；如果是后台管理员，改为管理员id
            article.setUpdateBy("studentId:" + article.getId());
            //id符合格式，但是id不存在报错为-3003
            long l = articleDao.updateById(article) > 0 ? article.getId() : -3003;
            log.info("result for update articleId={}", l);
            return l;
        }catch(ServiceException se){
            log.error("result for updateArticle error;reason is args error;detail exception is:{}",
                    se.getMessage());
            return null;
        }catch(IllegalArgumentException iae){
            //article为null
            log.error("updateArticle error;reason is args null; exception detail message is:{}", (Object) iae.getStackTrace());
            return null;
        }
    }

    /**后台更改文章状态
     * @param articleId 文章id
     * @param status 修改后的状态值
     * @param type 文章的类型
     * @return 成功后返回修改的记录的id
     */
    @Override
    public Long updateArticleStatus(Long articleId,Integer type,Integer status) {
        log.info("updateArticleStatus's args is: articleId={}&type={}&status={}",articleId,type,status);
        //文章类型为card，直接修改
        if(type==1 && status!=null && articleId!=null){
            Article article=new Article();
            article.setId(articleId);
            article.setStatus(status);
            article.setUpdateAt(System.currentTimeMillis());
            article.setUpdateBy("adminTest");
            long l = articleDao.updateById(article) > 0 ? article.getId() : -3003;
            log.info("result for updateArticleStatus's articleId={}", l);
            return l;
        } if(type==0 && status!=null && articleId!=null){
            //文章类型为banner
            //查询数据库中上架banner文章数量
        }
        return null;
    }

}
