package com.modespring.core.service;

import com.modespring.core.domain.Article;

import java.util.List;

/**
 * Created by Shawoe on 2015/5/14.
 */
public interface ArticleService {

    public List<Article> getArticleByColumnId(Integer id);

}