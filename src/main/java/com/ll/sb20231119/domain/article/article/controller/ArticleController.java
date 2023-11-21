package com.ll.sb20231119.domain.article.article.controller;

import com.ll.sb20231119.domain.article.article.entity.Article;
import com.ll.sb20231119.domain.article.article.service.ArticleService;
import com.ll.sb20231119.global.rsData.RsData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleService articleService;

    @GetMapping("/article/write")
    String write(){
        return "article/write";
    }

    @PostMapping ("/article/write")
    @ResponseBody
    RsData<Article> write(String title, String body){
        if(title == null || title.trim().length() == 0){
            throw new IllegalArgumentException("제목을 입력해주세요.");
        }

        if(title == null || body.trim().length() == 0){
            throw new IllegalArgumentException("내용을 입력해주세요.");
        }

        Article write = articleService.write(title, body);

        RsData<Article> rsData = new RsData<>("S-1", "%s번 글이 추가되었습니다.".formatted(write.getId()), write);

        return rsData;
    }

    @GetMapping("/article/getLastArticle")
    @ResponseBody
    Article getLastArticle(){
        return articleService.findLastarticle();
    }

    @GetMapping("/article/getArticles")
    @ResponseBody
    List<Article> getArticles(){
        return articleService.findAll();
    }
}

