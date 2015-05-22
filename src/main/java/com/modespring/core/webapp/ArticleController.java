package com.modespring.core.webapp;

import com.modespring.core.domain.Article;
import com.modespring.core.service.ArticleService;
import com.modespring.core.webapp.access.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpSession;

/**
 * Created by Shawoe on 2015/5/22.
 */
@Controller
@RequestMapping
public class ArticleController extends BaseController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "{name}/{id}", method = RequestMethod.GET)
    public ModelAndView getOne(ModelAndView modelAndView, HttpSession session, @PathVariable String name, @PathVariable Integer id) {
        modelAndView.addObject("nodeList",Context.getNodeList());
        Article article = articleService.getOne(id);
        modelAndView.addObject("article", article);
        modelAndView.setViewName("/article");
        return modelAndView;
    }
}
