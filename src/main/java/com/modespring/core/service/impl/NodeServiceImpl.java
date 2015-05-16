package com.modespring.core.service.impl;

import com.modespring.core.domain.Node;
import com.modespring.core.repository.NodeDao;
import com.modespring.core.service.NodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void delete(Integer id) {
        nodeDao.delete(id);
    }

    public Node update(Node node) {
        return nodeDao.saveAndFlush(node);
    }
    public void updateALL(List<Node> nodeList) {
        nodeDao.save(nodeList);
    }

    public Node getOne(Integer id){
        return nodeDao.findOne(id);
    }

    public Node getByName(String name){
        return nodeDao.findByName(name);
    }

    public List<Node> getAll() {
        return nodeDao.findAll();
    }

}
