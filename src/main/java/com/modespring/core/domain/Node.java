package com.modespring.core.domain;

import com.modespring.core.domain.bean.NodeBean;
import javax.persistence.Entity;

/**
 * Created by Shawoe on 2015/4/30.
 */
@Entity
public class Node extends NodeBean {

    public Node() {
        this.setLevel(0);
    }

    public Node(Node parentNode) {
        this.setLevel(parentNode.getLevel() + 1);
        this.setParentNode(parentNode);
    }
}
