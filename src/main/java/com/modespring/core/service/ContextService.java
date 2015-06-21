package com.modespring.core.service;

import com.modespring.core.domain.Node;
import com.modespring.core.domain.pojo.Mosp;
import com.modespring.core.domain.pojo.Site;
import org.apache.commons.configuration.ConfigurationException;

import java.util.List;

/**
 * Created by Shawoe on 2015/6/21.
 */
public interface ContextService {
    void flush() throws ConfigurationException;

    Site getSite();

    void setSite(Site site);

    List<Node> getNodeList();

    void setNodeList(List<Node> nodeList);

    List<Mosp> getMospList();

    void setMospList(List<Mosp> mospList);
}
