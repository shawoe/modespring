package com.modespring.core.repository;

import com.modespring.core.domain.Article;
import com.modespring.core.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Shawoe on 2015/4/30.
 */
@Repository
public interface ArticleDao extends JpaRepository<Article, Integer> {

    @Query("SELECT article FROM Article article WHERE article.column.id = ?1")
    public List<Article> findByColumnId(Integer id);

}
