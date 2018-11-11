package com.jnshu.sildenafil.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jnshu.sildenafil.system.domain.Forum;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jnshu.sildenafil.util.MyPage;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Taimur
 * @since 2018-10-31
 */
public interface ForumService extends IService<Forum> {
    /**
     * 帖子多条件模糊查询 
     * @param [title, author, start, end]
     * @return  java.util.List<com.jnshu.sildenafil.system.domain.Forum>
     */
    IPage forumFuzzySelect(Integer page, Integer size, String title, String author, Long start, Long end);
    IPage forumFrontList(Integer page,Integer size);
}
