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
    private String title;

    @OneToMany
    @JoinColumn
    private List<Node> childNodelist;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Node> getChildNodelist() {
        return childNodelist;
    }

    public void setChildNodelist(List<Node> childNodelist) {
        this.childNodelist = childNodelist;
    }
}
