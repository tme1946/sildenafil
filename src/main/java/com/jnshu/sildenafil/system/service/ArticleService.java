package com.jnshu.sildenafil.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jnshu.sildenafil.system.domain.Article;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author feifei
 * @since 2018-10-30
 */
public interface ArticleService extends IService<Article> {
    /**后台分页查询文章列表
     * @param page
     * @param size
     * @return 分页信息和数据信息
     */
    IPage getPageList(Integer page, Integer size,Article article);
    /**
     * @param articleId
     * @return
     */
    Article getArticle(Long articleId);
    /**增加文章
     * @param article
     * @return 插入后的article
     */
    Article saveArticle(Article article);


    /**更改文章状态
     * @param article
     * @return 成功后返回修改的记录的id
     */
    long changeArticle(Article article);

}
