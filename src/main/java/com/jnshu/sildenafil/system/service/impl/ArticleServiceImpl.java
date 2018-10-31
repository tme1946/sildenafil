package com.jnshu.sildenafil.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jnshu.sildenafil.system.domain.Article;
import com.jnshu.sildenafil.system.mapper.ArticleDao;
import com.jnshu.sildenafil.system.service.ArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jnshu.sildenafil.util.MyPage;
import lombok.Data;
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
    public IPage getPageList(int page, int size){
//        page= page<=1? 1 : page;
//        size= size<=1||size>20 ? 10 : size;
//        Page pageQuery=new Page(page,size).setDesc("update_at");
        MyPage pageQuery=new MyPage(page,size).setDesc("update_at");
        IPage articleIPage=articleDao.selectPage(pageQuery,null);
        return articleIPage;
    }

    @Override
    public Article saveArticle(Article article) {
        article.setCreateAt(System.currentTimeMillis());
        article.setUpdateAt(System.currentTimeMillis());
        article.setCreateBy("admin");
        article.setUpdateBy("admin");
        articleDao.insert(article);
        Long articleId=article.getId();
        Article article1=articleDao.selectById(articleId);
        return article1;
    }

    @Override
    public long changeArticle(Article article) {
        QueryWrapper<Article> queryWrapper= new QueryWrapper<>();
        queryWrapper.eq("id",article.getId());
        article.setUpdateAt(System.currentTimeMillis());
        article.setUpdateBy("changeTest");
        long l= articleDao.update(article,queryWrapper)>0 ? article.getId() : -1000;
        log.error("result for change articleId is {}",l);
        return l;
    }

}
