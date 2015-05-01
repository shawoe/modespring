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
        return nodeDao.save(node);
    }

    public void delete(Integer id) {
        nodeDao.delete(id);
    }

    public Node update(Node node) {
        return nodeDao.saveAndFlush(node);
    }

    public List<Node> getAll() {
        return nodeDao.findAll();
    }

}
