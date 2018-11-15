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


    /**前台分页查询card文章信息
     * @param page 页码
     * @param size 每页数量
     * @return 文章列表
     */
    IPage getFrontCardPageList(Integer page,Integer size);

    /**前台分页查询banner文章信息
     * @param page 页码
     * @param size 每页数量
     * @return 文章列表
     */
    IPage getFrontBannerPageList(Integer page,Integer size);

    /**前台根据文章id查询文章信息
     * @param articleId 文章id
     * @return 对应文章
     */
    Article getArticleById(Long articleId);


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
    IPage getAdminPageList(Integer page, Integer size,String title,String author,
                           Integer type,Integer status,Integer likeStart,Integer likeEnd,
                           Integer collectionStart,Integer collectionEnd);

    /**后台保存文章
     * @param article 文章信息
     * @return 插入后的article
     */
    Article saveArticle(Article article);


    /**后台更改文章信息
     * @param article 待更新信息
     * @return 成功后返回修改的记录的id
     */
    Long updateArticle(Article article);


    /**后台更改文章状态
     * @param articleId 文章id
     * @param status 修改后的状态值
     * @param type 文章的类型
     * @return 成功后返回修改的记录的id
     */
    Long updateArticleStatus(Long articleId,Integer type,Integer status);


}
