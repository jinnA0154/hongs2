package com.example.hongs2.dto;

import com.example.hongs2.entity.Article;
import lombok.Getter;

@Getter
public class PostListResponseDto {
    private Long id;
    private String title;
    private String content;

    public PostListResponseDto(Article article) {
        this.id = article.getId();
        this.title = article.getTitle();
        this.content = article.getContent();

    }
}
