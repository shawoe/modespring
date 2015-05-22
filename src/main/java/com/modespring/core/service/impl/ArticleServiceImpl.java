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
}
