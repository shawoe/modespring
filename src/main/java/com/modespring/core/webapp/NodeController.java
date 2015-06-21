package com.modespring.core.webapp;

import com.modespring.core.domain.Article;
import com.modespring.core.domain.Node;
import com.modespring.core.service.ArticleService;
import com.modespring.core.service.ContextService;
import com.modespring.core.service.NodeService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Shawoe on 2015/5/14.
 */
@Controller
@RequestMapping
public class NodeController {

    @Autowired
    protected ContextService contextService;

    @Autowired
    private NodeService nodeService;

    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "{name}", method = RequestMethod.GET)
    public ModelAndView getOne(ModelAndView modelAndView, HttpSession session, @PathVariable String name) {
        modelAndView.addObject("nodeList", contextService.getNodeList());
        modelAndView.addObject("site", contextService.getSite());
        Node node = nodeService.getByName(name);
        modelAndView.addObject("node", node);
        List<Article> articleList = articleService.getByNodeId(node.getId());
        modelAndView.addObject("articleList", articleList);
        if (StringUtils.isBlank(node.getUrl())) {
            modelAndView.setViewName("/column");
        } else {
            modelAndView.setViewName(node.getUrl());
        }
        return modelAndView;
    }

}
