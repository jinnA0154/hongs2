package com.example.hongs2.entity;

// dto랑 거의 비슷. Entity를 선언한다.

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Data
@Entity // DB가 해당 객체를 인식 가능
public class Article {

    @Id // 기본적으로 Entity는 대표값을 하나 넣어줘야. 주민번호 같이 고유값. 아래의 Column들이 같은 값이라도 구별해야.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 1,2,3, ... 자동 생성 어노테이션!
    private Long id;

    @Column
    private String title;

    @Column
    private String content;

    // 아래 코드 한줄 때문에 5월 15일 하루를 쩔쩔맸다..ㅠ 아래 생성자 말고 이 생성자가 또 필요하네...왜?? 아무튼 만세!!
    private Article() {  //기본 생성자 추가

    }

    // 생성자를 추가한다. 자동생성.  => @AllArgsConstructor 으로 대체
    public Article(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }


}
