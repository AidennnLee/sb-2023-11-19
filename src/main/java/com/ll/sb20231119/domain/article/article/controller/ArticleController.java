package com.ll.sb20231119.domain.article.article.controller;

import com.ll.sb20231119.domain.article.article.entity.Article;
import com.ll.sb20231119.global.rsData.RsData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ArticleController {
    private List<Article> articles = new ArrayList<>();

    @GetMapping("/article/write")
    String write(){
        return "article/write";
    }

    @PostMapping ("/article/write")
    @ResponseBody
    RsData<Article> write(String title, String body){
        Article article = new Article(articles.size() + 1, title, body);
        articles.add(article);

        RsData<Article> rsData = new RsData<>("S-1", "%s번 글이 추가되었습니다.".formatted(article.getId()), article);

        return rsData;
    }

    @GetMapping("/article/getLastArticle")
    @ResponseBody
    Article getLastArticle(){
        return articles.getLast();
    }

    @GetMapping("/article/getArticles")
    @ResponseBody
    List<Article> getArticles(){
        return articles;
    }
}

