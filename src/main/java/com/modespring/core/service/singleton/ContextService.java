package com.modespring.core.service.singleton;

import com.modespring.core.domain.Node;
import com.modespring.core.domain.Site;
import com.modespring.core.repository.NodeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Shawoe on 2015/4/30.
 */
@Service
@Scope(value = "singleton")
public class ContextService {

    private Site context;
    private List<Node> nodeList;

    @Autowired
    NodeDao nodeDao;

    @Autowired
    public ContextService(NodeDao nodeDao) {
        this.nodeList = nodeDao.findAll();
    }

    public void flush() {
        this.nodeList = nodeDao.findAll();
    }

    public Site getContext() {
        return context;
    }

    public void setContext(Site context) {
        this.context = context;
    }

    public List<Node> getNodeList() {
        return nodeList;
    }

    public void setNodeList(List<Node> nodeList) {
        this.nodeList = nodeList;
    }
}
