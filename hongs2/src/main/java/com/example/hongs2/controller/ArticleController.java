package com.example.hongs2.controller;

import com.example.hongs2.dto.ArticleForm;
import com.example.hongs2.entity.Article;
import com.example.hongs2.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/articles")
public class ArticleController {

    @Autowired // articleRepository 객체를 생성문을 작성해야 하지만 스프링부트가 미리 생성해 놓은 객체를 가져다가 자동으로 연결해 주기 때문에 이 어노테이션을 사용하면 객체생성 선언을 할 필요가 없다.
    private ArticleRepository articleRepository;


    // html 양식을 띄우는 컨트롤러
    @GetMapping("/new")
    public String newArticleForm () {
        return "articles/new";
    }

    // html 양식에 입력한 DATA를 가져오는 컨트롤러 , 파라메터에 DTO를 넣어야함
    // DB로 전달을 위한 과정도 여기에...
    @PostMapping("/create")
    public String createArticle (ArticleForm form) {
        System.out.println(form.toString()); // form이라는 DTO에 담긴 내용을 확인. 안좋은 방법. 나중에는 logging 방식으로 바꿔야.

        // 1. Dto를 Entity로 변환
        // form에서 toEntity 메소드를 호출해서 Article이라는 타입에 반환하는 형식으로.
        // Artical 빨간색 없는 것. 커서를 대어 Class를 새로 만들어 주도록 하자. entity 페키지에.
        // toEntity 빨간색 없는 것. form(DTO) Class에서 메소드를 만들어 주자.
        Article article = form.toEntity();
        System.out.println(article.toString()); // 확인용

        // 2. Repository에게 Entity를 DB안에 저장하게 함.
        // articleRepository 빨간색. 위쪽에 필드 추가.
        // CrudRepository를 상속받은 articleRepository는 기본 메소드들을 모두 사용할 수있다. save() 등등
        Article saved = articleRepository.save(article);
        System.out.println(saved.toString()); // 확인용

       return "";
    }

    @GetMapping("/index")
    public String index(Model model) {

        List<Article> articles = articleRepository.findAll();

        model.addAttribute("article", articles);
        return "articles/index";
    }

}
