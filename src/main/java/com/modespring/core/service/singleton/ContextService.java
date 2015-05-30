package com.modespring.core.service.singleton;

import com.modespring.core.domain.pojo.Mosp;
import com.modespring.core.domain.Node;
import com.modespring.core.domain.Site;
import com.modespring.core.repository.NodeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shawoe on 2015/4/30.
 */
@Service
@Scope(value = "singleton")
public class ContextService {

    private Site context;
    private List<Node> nodeList;
    private List<Mosp> mospList;

    @Autowired
    private NodeDao nodeDao;

    @Autowired
    public ContextService(NodeDao nodeDao) {
        this.nodeList = nodeDao.findAll();
        this.initMosplist();
    }

    protected void initMosplist () {
        mospList = new ArrayList<>();
        mospList.add(new Mosp("count","站点统计"));
        mospList.add(new Mosp("global","全局设置"));
        mospList.add(new Mosp("node","栏目管理"));
        mospList.add(new Mosp("model","模型管理"));
        mospList.add(new Mosp("power","权限管理"));
        mospList.add(new Mosp("user","用户管理"));
        mospList.add(new Mosp("logging","日志管理"));
        mospList.add(new Mosp("about","关于我们"));
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

    public List<Mosp> getMospList() {
        return mospList;
    }

    public void setMospList(List<Mosp> mospList) {
        this.mospList = mospList;
    }
}
