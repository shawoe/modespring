package com.modespring.core.service.impl;

import com.modespring.core.domain.Node;
import com.modespring.core.repository.NodeDao;
import com.modespring.core.service.NodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shawoe on 2015/5/1.
 */
@Service
public class NodeServiceImpl implements NodeService {

    @Autowired
    NodeDao nodeDao;

    public Node create(Node node) {
        Node parentNode = nodeDao.findOne(node.getParentNode().getId());
        node.setLevel(parentNode.getLevel() + 1);
        return nodeDao.save(node);
    }

    public Boolean hasArticle(Integer id) {
        List<Node> nodeList = nodeDao.findAll();
        return nodeList.size() > 0;
    }

    public void delete(Integer id) throws Exception {
        if (this.hasArticle(id)) {
            throw new Exception("该栏目下有未删除的文章");
        } else {
            nodeDao.delete(id);
        }
    }

    @Override
    public void deleteAll(Integer[] id) throws Exception {
        for (int i = 0; id != null && i < id.length; i++) {
            if (this.hasArticle(id[i])) {
                throw new Exception("该栏目下有未删除的文章");
            } else {
                nodeDao.delete(id[i]);
            }
        }
    }

    public Node update(Node node) {
        return nodeDao.saveAndFlush(node);
    }

    public List<Node> updateALL(List<Node> nodeList) {
        return nodeDao.save(nodeList);
    }

    @Override
    public List<Node> updateALL(Integer[] id, String[] name, String[] title) {
        List<Node> nodeList = new ArrayList<Node>();
        for (int i = 0; i < id.length; i++) {
            Node node = nodeDao.getOne(id[i]);
            node.setName(name[i]);
            node.setTitle(title[i]);
            nodeList.add(node);
        }
        return nodeDao.save(nodeList);
    }

    public Node getOne(Integer id) {
        return nodeDao.findOne(id);
    }

    public Node getByName(String name) {
        return nodeDao.findByName(name);
    }

    public List<Node> getAll() {
        return nodeDao.findAll();
    }

}
