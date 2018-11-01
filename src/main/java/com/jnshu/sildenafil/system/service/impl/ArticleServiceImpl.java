package com.jnshu.sildenafil.system.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jnshu.sildenafil.system.domain.Article;
import com.jnshu.sildenafil.system.mapper.ArticleDao;
import com.jnshu.sildenafil.system.service.ArticleService;
import com.jnshu.sildenafil.util.MyPage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author feifei
 * @since 2018-10-30
 */
@Slf4j
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleDao, Article> implements ArticleService {

    @Autowired(required = false)
    private ArticleDao articleDao;

    @Override
    public IPage getPageList(Integer page, Integer size,Article article){
        log.info("args for getArticlePageList is:*** page={}&size={}&{} ***"
                ,page,size,article);
        //调整page和size--默认会调整
//        page= page<=1? 1 : page;
//        size= size<=1||size>20 ? 10 : size;
        MyPage pageQuery=new MyPage(page,size).setDesc("update_at");
        QueryWrapper<Article> queryWrapper=new QueryWrapper<>();
        if(article!=null) {
            queryWrapper
                    .like(StringUtils.isNotEmpty(article.getTitle()), "title", article.getTitle())
                    .like(StringUtils.isNotEmpty(article.getAuthor()), "author", article.getAuthor())
                    .eq(null != article.getType(), "type", article.getType())
                    .eq(null != article.getStatus(), "status", article.getStatus())
            ;
        }
        IPage articleIPage=articleDao.selectPage(pageQuery,queryWrapper);
        if(articleIPage.getRecords().size()>0)
        {
            log.info("result for pageArticleList's size is {}",articleIPage.getRecords().size());
        } else{
            log.error("result for pageArticleList error :***reason is list null***");
        }
        return articleIPage;
    }

    /**
     * @return
     */
    @Override
    public  Article getArticle(Long articleId) {
        log.info("args for getArticleById is : articleId={}",articleId);
        if (null != articleId) {
            Article article=articleDao.selectById(articleId);
            log.info("result for getArticleById is :{}",article);
            return article;
        }else{
            log.error("result for getArticleById is error;reason :args is null");
            return null;
        }
    }

    @Override
    public Article saveArticle(Article article) {
        log.info("args for saveArticle is: {}",article);
        //参数验证，验证必要的参数是否填了；
        article.setCreateAt(System.currentTimeMillis());
        article.setUpdateAt(System.currentTimeMillis());
        article.setCreateBy("studentId:"+article.getId());
        article.setUpdateBy("studentId:"+article.getId());
        long l= articleDao.insert(article)>0 ? article.getId() : -3002;
        log.info("result for save articleId={};{}",l,article);
        return article;
    }

    @Override
    public Long changeArticle(Article article) {
        log.info("changeArticle's args is {}",article);
        //参数验证
        try {
            if(article.getId()==null){throw new NullPointerException();}//此句话同时判断article和articleI的是否为null
            article.setUpdateAt(System.currentTimeMillis());
            //设置更改人；如果是后台管理员，改为管理员id
            article.setUpdateBy("studentId:" + article.getId());
            long l = articleDao.updateById(article) > 0 ? article.getId() : -3003;
            log.info("result for change articleId={}", l);
            return l;
        }catch(NullPointerException npe){
            //article为null;或article.getId为null；
            log.error("changeArticle error;reason is args null; exception detail message is:{}",npe.getStackTrace());
            return null;
        }
    }

}
