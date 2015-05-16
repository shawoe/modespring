package com.modespring.core.domain;

import com.modespring.core.domain.bean.ArticleBean;
import javax.persistence.Entity;
import java.util.Date;

/**
 * Created by Shawoe on 2015/4/30.
 */
@Entity
public class Article extends ArticleBean {

    public Article(Node column) {
        this.setColumn(column);
        this.setPublishDate(new Date());
    }

}
