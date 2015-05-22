package com.modespring.core.webapp;

import com.modespring.core.domain.Article;
import com.modespring.core.domain.Node;
import com.modespring.core.service.ArticleService;
import com.modespring.core.service.NodeService;
import com.modespring.core.webapp.access.BaseController;
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
public class NodeController extends BaseController {

    @Autowired
    private NodeService nodeService;

    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "{name}", method = RequestMethod.GET)
    public ModelAndView getOne(ModelAndView modelAndView, HttpSession session, @PathVariable String name) {
        modelAndView.addObject("nodeList",Context.getNodeList());
        Node node = nodeService.getByName(name);
        List<Article> articleList = articleService.getByNodeId(node.getId());
            modelAndView.addObject("node", node);
        modelAndView.addObject("articleList", articleList);
        if (node.getUrl() == null) {
            modelAndView.setViewName("/column");
        } else {
            modelAndView.setViewName(node.getUrl());
        }
        return modelAndView;
    }

}
