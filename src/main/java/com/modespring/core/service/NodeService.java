package com.modespring.core.service;

import com.modespring.core.domain.Node;
import java.util.List;

/**
 * Created by Shawoe on 2015/5/1.
 */
public interface NodeService {

    public Node create(Node node);

    public void delete(Integer id);

    public Node update(Node node);

    public List<Node> getAll();

}
