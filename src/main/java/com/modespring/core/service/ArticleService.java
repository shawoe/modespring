package com.modespring.core.service;

import com.modespring.core.domain.Article;
import com.modespring.core.domain.Field;

import java.util.List;

/**
 * Created by Shawoe on 2015/5/14.
 */
public interface ArticleService extends BaseService<Article> {

    public List<Article> getByNodeId(Integer id);
    public List<Field> addFieldValue(String fieldName[], String fieldTitle[], String fieldValue[]);

}
