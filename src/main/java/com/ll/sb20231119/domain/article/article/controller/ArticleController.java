package com.ll.sb20231119.domain.article.article.controller;

import com.ll.sb20231119.domain.article.article.entity.Article;
import com.ll.sb20231119.domain.article.article.service.ArticleService;
import com.ll.sb20231119.global.rsData.RsData;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @Data
    public static class WriteForm{
        @NotBlank
        private String title;
        @NotBlank
        private String body;
    }

    @PostMapping ("/article/write")
    @ResponseBody
    RsData<Article> write(@Valid WriteForm writeform){

        Article write = articleService.write(writeform.title, writeform.body);

        RsData<Article> rs = new RsData<>(
                "S-1", "%s번 글이 추가되었습니다.".formatted(write.getId()),
                write);

        return rs;
    }

    @GetMapping ("/article/list")
    String showList (Model model){
        List<Article> articles = articleService.findAll();

        model.addAttribute("articles", articles);

        return "article/list";
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

