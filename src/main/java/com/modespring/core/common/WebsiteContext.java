package com.modespring.core.common;

import com.modespring.core.domain.Node;
import com.modespring.core.domain.Website;
import com.modespring.core.repository.NodeDao;
import com.modespring.core.repository.WebsiteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

/**
 * Created by Shawoe on 2015/4/30.
 */
@Service
public class WebsiteContext extends ModelAndView {

    private Website context;
    private List<Node> nodeList;

    @Autowired
    public WebsiteContext(WebsiteDao websiteDao, NodeDao nodeDao) {
        this.nodeList = nodeDao.findAll();
        this.addObject("nodeList", nodeList);
    }

}
