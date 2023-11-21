package com.ll.sb20231119.domain.article.article.repository;

import com.ll.sb20231119.domain.article.article.entity.Article;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ArticleRepository {
    private final List<Article> articles = new ArrayList<>();

    public Article save(String title, String body) {
        Article article = new Article(articles.size() + 1, title, body);
        articles.add(article);

        return article;
    }

    public Article findLastarticle() {
        return articles.getLast();
    }

    public List<Article> findAll() {
        return articles;
    }
}
