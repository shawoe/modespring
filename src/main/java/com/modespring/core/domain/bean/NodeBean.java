package com.modespring.core.domain.bean;

import com.modespring.core.domain.Node;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Shawoe on 2015/4/30.
 */
@MappedSuperclass
public abstract class NodeBean  extends BaseBean {

    @Column(nullable = false)
    private String name;

    private String url;

    @Column(nullable = false)
    private Integer level;

    @ManyToOne
    @JoinColumn
    private Node parentNode;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Node getParentNode() {
        return parentNode;
    }

    public void setParentNode(Node parentNode) {
        this.parentNode = parentNode;
    }
}
