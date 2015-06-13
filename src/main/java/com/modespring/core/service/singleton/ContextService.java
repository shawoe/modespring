package com.modespring.core.service.singleton;

import com.modespring.core.domain.pojo.Mosp;
import com.modespring.core.domain.Node;
import com.modespring.core.domain.pojo.Site;
import com.modespring.core.repository.NodeDao;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
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

    private Site site;
    private List<Node> nodeList;
    private List<Mosp> mospList;

    @Autowired
    private NodeDao nodeDao;

    @Autowired
    public ContextService(NodeDao nodeDao) {
        this.nodeList = nodeDao.findAll();
        this.initMosplist();
        this.initSite();
    }

    protected void initSite () {
        PropertiesConfiguration properties = new PropertiesConfiguration();
        properties.setEncoding("utf8");
        try {
            properties.load("global.properties");
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
        this.site = new Site();
        this.site.setTitle(properties.getString("site.title"));
        this.site.setLogo(properties.getString("site.logo"));
        this.site.setUrl(properties.getString("site.url"));
        this.site.setMospUrl(properties.getString("site.mospUrl"));
    }

    protected void initMosplist () {
        PropertiesConfiguration properties = new PropertiesConfiguration();
        properties.setEncoding("utf8");
        try {
            properties.load("modespring.properties");
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
        String[] mospName = properties.getString("column.name").split("\\|");
        String[] mospTitle = properties.getString("column.title").split("\\|");
        this.mospList = new ArrayList<>();
        for (int i = 0; i < mospName.length && i < mospTitle.length; i++) {
            mospList.add(i, new Mosp(mospName[i], mospTitle[i]));
        }
    }

    public void flush() {
        this.nodeList = nodeDao.findAll();
    }

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
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
