package com.modespring.core.service.singleton;

import com.modespring.core.common.PropertiesUtil;
import com.modespring.core.domain.Node;
import com.modespring.core.domain.pojo.Mosp;
import com.modespring.core.domain.pojo.Site;
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
        this.site = new Site();
        this.site.setTitle(PropertiesUtil.getStringProperty("global","site.title"));
        this.site.setLogo(PropertiesUtil.getStringProperty("global", "site.logo"));
        this.site.setUrl(PropertiesUtil.getStringProperty("global", "site.url"));
        this.site.setMospUrl(PropertiesUtil.getStringProperty("global", "site.mospUrl"));
    }

    protected void initMosplist () {
        String[] mospName = PropertiesUtil.getStringProperties("modespring", "column.name");
        String[] mospTitle = PropertiesUtil.getStringProperties("modespring", "column.title");
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
