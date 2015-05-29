package com.modespring.core.domain;

import com.modespring.core.domain.bean.ArticleBean;

import javax.persistence.Entity;
import java.util.Date;

/**
 * Created by Shawoe on 2015/4/30.
 */
@Entity
public class Article extends ArticleBean {

    public Article(Node node) {
        this.setNode(node);
        this.setNodeTree(this.addNodeTree(node));
        this.setPublishDate(new Date());
    }

    public Article() {
    }

    private String addNodeTree(Node node) {
        String nodeTree = node.getName();
        while (node.getParentNode() != null) {
            node = node.getParentNode();
            nodeTree = nodeTree + "-" + node.getName();
        }
        return nodeTree;
    }
}
