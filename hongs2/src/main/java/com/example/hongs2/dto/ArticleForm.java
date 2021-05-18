package com.example.hongs2.dto;

import com.example.hongs2.entity.Article;
import lombok.NoArgsConstructor;


public class ArticleForm {
    private String title;
    private String content;

    // 자동생성 : 우클릭 > generate > constructor > 필드 2개 선택 후 OK
    public ArticleForm(String title, String content) {
        this.title = title;
        this.content = content;
    }

    // 자동생성 : 우클릭 > generate > toString > 필드 2개 선택 후 OK
    @Override
    public String toString() {
        return "ArticleForm{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }


    public Article toEntity() {
        // 새롭게 Article을 만들어서 반환하자. Article은 Entity 임. 생성자를 확인하자.
        return new Article(null, title, content);
    }
}
