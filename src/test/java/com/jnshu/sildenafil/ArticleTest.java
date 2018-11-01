package com.jnshu.sildenafil;

import com.jnshu.sildenafil.system.domain.Article;
import com.jnshu.sildenafil.system.service.ArticleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleTest {
    @Autowired
    private ArticleService articleService;

    @Test
    public void testPageList() {
        Article article=new Article();
        articleService.getPageList(1,null,null);
    }

    @Test
    public void getOneArticle() {

        articleService.getArticle(23L);
    }

    @Test
    public void saveArticle() {

    }

    @Test
    public void changeArticle() {
        Article article=new Article();
        articleService.changeArticle(null);
    }
}
