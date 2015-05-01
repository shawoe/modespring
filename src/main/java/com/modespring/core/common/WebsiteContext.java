package com.modespring.core.common;

import com.modespring.core.domain.Node;
import com.modespring.core.domain.Website;
import com.modespring.core.repository.NodeDao;
import com.modespring.core.repository.WebsiteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

/**
 * Created by Shawoe on 2015/4/30.
 */
@Service
@Scope(value = "singleton")
public class WebsiteContext {

    private Website context;
    private List<Node> nodeList;

    public Website getContext() {
        return context;
    }

    public void setContext(Website context) {
        this.context = context;
    }

    public List<Node> getNodeList() {
        return nodeList;
    }

    public void setNodeList(List<Node> nodeList) {
        this.nodeList = nodeList;
    }

//    @Autowired
//    public WebsiteContext() {
//
//    }

    @Autowired
    public WebsiteContext(NodeDao nodeDao) {
//        super();
        this.nodeList = nodeDao.findAll();
//        this.addObject("nodeList", nodeList);
    }

}
