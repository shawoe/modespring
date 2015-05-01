package com.modespring.core.domain.bean;

import com.modespring.core.domain.Node;
import com.modespring.core.domain.User;
import javax.persistence.*;
import java.util.Date;

/**
 * Created by Shawoe on 2015/4/30.
 */
@MappedSuperclass
public abstract class ArticleBean  extends BaseBean {

    private String title;

    private Date publishDate;

    @ManyToOne
    @JoinColumn
    private User author;

    @ManyToOne
    @JoinColumn
    private Node column;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Node getColumn() {
        return column;
    }

    public void setColumn(Node column) {
        this.column = column;
    }
}
