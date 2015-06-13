package com.modespring.core.domain.bean;

import com.modespring.core.domain.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Shawoe on 2015/4/30.
 */
@MappedSuperclass
public abstract class ArticleBean extends BaseBean {

    private Date publishDate;

    @Column(columnDefinition="BLOB")
    private String content;

    private String nodeTree;

    @ManyToOne
    @JoinColumn
    private User author;

    @ManyToOne
    @JoinColumn
    private Node node;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable
    private List<Field> valueList;

    @OneToMany
    @JoinColumn
    private List<Image> imageList;

    @OneToMany
    @JoinColumn
    private List<File> fileList;

    protected ArticleBean() {
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

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    public String getNodeTree() {
        return nodeTree;
    }

    public void setNodeTree(String nodeTree) {
        this.nodeTree = nodeTree;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Field> getValueList() {
        return valueList;
    }

    public void setValueList(List<Field> valueList) {
        this.valueList = valueList;
    }

    public List<Image> getImageList() {
        return imageList;
    }

    public void setImageList(List<Image> imageList) {
        this.imageList = imageList;
    }

    public List<File> getFileList() {
        return fileList;
    }

    public void setFileList(List<File> fileList) {
        this.fileList = fileList;
    }
}
