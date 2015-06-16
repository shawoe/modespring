package com.modespring.core.webapp.modespring;

import com.modespring.core.domain.Article;
import com.modespring.core.domain.Node;
import com.modespring.core.service.ArticleService;
import com.modespring.core.service.NodeService;
import com.modespring.core.webapp.access.BaseController;
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
 * Created by Shawoe on 2015/5/22.
 */
@Controller
@RequestMapping(value = "modespring")
public class ArticleManageController extends BaseController {

    @Autowired
    private NodeService nodeService;

    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "{nodeName}/article", method = RequestMethod.GET)
    public ModelAndView getOne(ModelAndView modelAndView, HttpSession session, @PathVariable String nodeName) {
        modelAndView.addObject("mospList", Context.getMospList());
        modelAndView.addObject("MospNodeName", "node");
        modelAndView.addObject("nodeList", Context.getNodeList());
        modelAndView.addObject("site", Context.getSite());
        Node node = nodeService.getByName(nodeName);
        modelAndView.addObject("node", node);
        List<Article> articleList = articleService.getByNodeId(node.getId());
        modelAndView.addObject("articleList", articleList);
        if (StringUtils.isBlank(node.getUrl())) {
            modelAndView.setViewName("/modespring/article");
        } else {
            modelAndView.setViewName(node.getUrl());
        }
        return modelAndView;
    }

    @RequestMapping(value = "{nodeName}/article", method = RequestMethod.DELETE)
    public ModelAndView editAll(ModelAndView modelAndView, HttpSession session, @PathVariable String nodeName, Integer[] delete) {
        try {
            articleService.deleteAll(delete);
        } catch (Exception e) {
            e.printStackTrace();
        }
        modelAndView.setViewName("redirect:/modespring/" + nodeName + "/article.html");
        return modelAndView;
    }

}
