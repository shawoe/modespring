package com.modespring.core.webapp;

import com.modespring.core.domain.Article;
import com.modespring.core.domain.Node;
import com.modespring.core.service.ArticleService;
import com.modespring.core.service.NodeService;
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
@RequestMapping(value = "node")
public class NodeController extends BaseController {

    @Autowired
    private NodeService nodeService;

    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ModelAndView getOne(ModelAndView modelAndView, HttpSession session, @PathVariable Integer id) {
        Node node = nodeService.getOne(id);
        List<Article> articleList = articleService.getArticleByColumnId(id);
        modelAndView.addObject("node", node);
        modelAndView.addObject("nodeList", Context.getNodeList());
        modelAndView.addObject("articleList", articleList);
        modelAndView.setViewName(node.getUrl());
        return modelAndView;
    }

}
