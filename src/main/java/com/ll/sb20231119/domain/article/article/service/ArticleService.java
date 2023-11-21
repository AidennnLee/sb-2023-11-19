package com.ll.sb20231119.domain.article.article.service;

import com.ll.sb20231119.domain.article.article.entity.Article;
import com.ll.sb20231119.domain.article.article.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;

    public Article write(String title, String body) {
        Article article = articleRepository.save(title, body);

        return article;
    }

    public Article findLastarticle() {
        return articleRepository.findLastarticle();
    }

    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    public Optional<Article> findById(long id) {
        return articleRepository.findById(id);
    }
}
