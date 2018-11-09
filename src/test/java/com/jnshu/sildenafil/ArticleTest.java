package com.jnshu.sildenafil;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jnshu.sildenafil.system.domain.Article;
import com.jnshu.sildenafil.system.service.ArticleService;
import com.jnshu.sildenafil.util.MyPage;
import com.jnshu.sildenafil.util.ValidationUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleTest {
    @Autowired
    private ArticleService articleService;

    @Test
    public void testPageList() {

        IPage articleMyPage=articleService.getAdminPageList(null,null,null,null,null,
                null,30,80,500,800);
        for (Object o : articleMyPage.getRecords()) {
            System.out.println(o);
        }
    }

    @Test
    public void getOneArticle() {

        articleService.getArticleById(23L);
    }

    @Test
    public void saveArticle() {
        Article article=new Article();
        articleService.saveArticle(null);
    }

    @Test
    public void updateArticle() {
        Article article=new Article();
        articleService.updateArticle(article);
    }

    @Test
    public void validation() {
        Article article=new Article();
//        article.setAuthor("yuefeifei");
//        @Valid
//        ValidationUtils.validate(article);
    }

    @Test
    public void save() {
        Article article=new Article();
        articleService.saveArticle(null);
    }
}
