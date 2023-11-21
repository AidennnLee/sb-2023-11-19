package com.ll.sb20231119.global.app;

import com.ll.sb20231119.domain.article.article.entity.Article;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedList;
import java.util.List;

@Configuration
public class AppConfig {
    @Bean
    List<Article> articles(){
        return new LinkedList<>();
    }
}
