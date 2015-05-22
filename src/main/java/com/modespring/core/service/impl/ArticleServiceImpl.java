package com.modespring.core.service.impl;

import com.modespring.core.domain.Article;
import com.modespring.core.repository.ArticleDao;
import com.modespring.core.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Created by Shawoe on 2015/5/14.
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    public List<Article> getByNodeId(Integer id) {
        return articleDao.findByNodeId(id);
    }

    public Article create(Article article) {
        return articleDao.save(article);
    }

    public void delete(Integer id) {
        articleDao.delete(id);
    }

    public Article update(Article article) {
        return articleDao.saveAndFlush(article);
    }
    public void updateALL(List<Article> articleList) {
        articleDao.save(articleList);
    }

    public Article getOne(Integer id){
        return articleDao.findOne(id);
    }

    public Article getByName(String name){
        return null;
    }

    public List<Article> getAll() {
        return articleDao.findAll();
    }
}
