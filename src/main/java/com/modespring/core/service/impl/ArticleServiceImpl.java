package com.modespring.core.service.impl;

import com.modespring.core.domain.Article;
import com.modespring.core.domain.Field;
import com.modespring.core.repository.ArticleDao;
import com.modespring.core.repository.FieldDao;
import com.modespring.core.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shawoe on 2015/5/14.
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private FieldDao fieldDao;

    public List<Article> getByNodeId(Integer id) {
        return articleDao.findByNodeId(id);
    }

    @Override
    public List<Field> addFieldValue(String fieldName[], String fieldTitle[], String fieldValue[]) {
        List<Field> fieldList = new ArrayList<>();
        if (fieldName != null) {
            for (int i = 0; i < fieldName.length; i++) {
                Field field = new Field();
                field.setName(fieldName[i]);
                field.setTitle(fieldTitle[i]);
                field.setValue(fieldValue[i]);
                fieldList.add(field);
            }
        }
        return fieldDao.save(fieldList);
    }

    public Article create(Article article) {
        return articleDao.save(article);
    }

    public void delete(Integer id) {
        articleDao.delete(id);
    }

    @Override
    public void deleteAll(Integer[] id) throws Exception {
        for (int i = 0; id != null && i < id.length; i++) {
                articleDao.delete(id[i]);
        }
    }

    public Article update(Article article) {
        return articleDao.saveAndFlush(article);
    }

    public List<Article> updateALL(List<Article> articleList) {
        return articleDao.save(articleList);
    }

    @Override
    public List<Article> updateALL(Integer[] id, String[] name, String[] title) {
        return null;
    }

    public Article getOne(Integer id) {
        return articleDao.findOne(id);
    }

    public Article getByName(String name) {
        return null;
    }

    public List<Article> getAll() {
        return articleDao.findAll();
    }
}
