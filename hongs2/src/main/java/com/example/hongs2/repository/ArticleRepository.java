package com.example.hongs2.repository;

import com.example.hongs2.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

// 우리가 repository를 직접구현할 수 있지만 jpa에서 제공하는 repository 인터페이스를 활용해서 쉽게 만들자.
// CrudRepository라는 인터페이스에서 상속받자. CRUD 기능을 추가 코드 구현없이 확장받아 사용 가능.
public interface ArticleRepository extends JpaRepository<Article, Long> {



}


