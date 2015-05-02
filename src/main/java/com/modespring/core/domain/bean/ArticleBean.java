package com.modespring.core.domain.bean;

import com.modespring.core.domain.Field;
import com.modespring.core.domain.Node;
import com.modespring.core.domain.User;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Shawoe on 2015/4/30.
 */
@MappedSuperclass
public abstract class ArticleBean  extends BaseBean {

    private String title;

    private Date publishDate;

    private String content;

    @ManyToOne
    @JoinColumn
    private User author;

    @ManyToOne
    @JoinColumn
    private Node column;

    @ManyToMany
    private List<Field> fieldList;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Field> getFieldList() {
        return fieldList;
    }

    public void setFieldList(List<Field> fieldList) {
        this.fieldList = fieldList;
    }

}
