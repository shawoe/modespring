package com.modespring.core.domain.bean;

import com.modespring.core.domain.Node;

import javax.persistence.*;

/**
 * Created by Shawoe on 2015/4/30.
 */
@MappedSuperclass
public abstract class NodeBean {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn
    private Node parentNode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Node getParentNode() {
        return parentNode;
    }

    public void setParentNode(Node parentNode) {
        this.parentNode = parentNode;
    }
}
