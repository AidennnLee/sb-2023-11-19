package com.ll.sb20231119.domain.article.article.controller;

import com.ll.sb20231119.domain.article.article.entity.Article;
import com.ll.sb20231119.domain.article.article.service.ArticleService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
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

    @Data
    public static class ModifyForm{
        @NotBlank
        private String title;
        @NotBlank
        private String body;
    }


    @PostMapping ("/article/write")
    String write(@Valid WriteForm writeForm){
        Article write = articleService.write(writeForm.title, writeForm.body);

        String msg = "%s번 게시물이 추가되었습니다.".formatted(write.getId());
        msg = URLEncoder.encode(msg, StandardCharsets.UTF_8);

        //리다이렉트. 브라우저의 주소를 다음으로 바꾸도록 함.
        return "redirect:/article/list?msg=" + msg;
    }

    @GetMapping ("/article/list")
    String showList (Model model){
        List<Article> articles = articleService.findAll();

        model.addAttribute("articles", articles);

        return "article/list";
    }

    @GetMapping ("/article/detail/{id}")
    String showDetail (Model model, @PathVariable long id){
        Article article = articleService.findById(id).get();
        model.addAttribute("article", article);

        return "article/detail";
    }

    @GetMapping ("/article/modify/{id}")
    String showModify (Model model, @PathVariable long id){
        Article article = articleService.findById(id).get();
        model.addAttribute("article", article);

        return "article/modify";
    }

    @PostMapping("/article/modify/{id}")
    String modify(@PathVariable long id, @Valid ModifyForm modifyForm){
        articleService.modify(id, modifyForm.title, modifyForm.body);

        String msg = "%s번 게시물이 수정되었습니다.".formatted(id);
        msg = URLEncoder.encode(msg, StandardCharsets.UTF_8);

        return "redirect:/article/list?msg=" + msg;
    }

    @GetMapping ("/article/delete/{id}")
    String delete (@PathVariable long id){
        articleService.delete(id);
        String msg = "%s번 게시물이 삭제되었습니다".formatted(id);
        msg = URLEncoder.encode(msg, StandardCharsets.UTF_8);

        return "redirect:/article/list?msg=" + msg;
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

