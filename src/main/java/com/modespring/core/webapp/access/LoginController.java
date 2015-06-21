package com.modespring.core.webapp.access;

import com.modespring.core.domain.Node;
import com.modespring.core.domain.User;
import com.modespring.core.service.ContextService;
import com.modespring.core.service.NodeService;
import com.modespring.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * Created by Shawoe on 2015/5/12.
 */
@Controller
@RequestMapping
public class LoginController {

    @Autowired
    protected ContextService contextService;

    @Autowired
    private NodeService nodeService;

    @Autowired
    public UserService userService;

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public ModelAndView login(ModelAndView modelAndView, HttpSession session) {
        modelAndView.addObject("nodeList", contextService.getNodeList());
        modelAndView.addObject("site", contextService.getSite());
        Node node = nodeService.getByName("member");
        modelAndView.addObject("node", node);
        if (session.getAttribute("currentUserName") != null) {
            modelAndView.setViewName("redirect:/center.html");
        }
        return modelAndView;
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ModelAndView loginAction(ModelAndView modelAndView, HttpSession session, User user) {
        try {
            user = userService.login(user.getName(), user.getPassword());
            session.setAttribute("currentUserName", user.getName());
            modelAndView.setViewName("redirect:/center.html");
        } catch (Exception e) {
            modelAndView.addObject("errorMessage", e.getMessage());
        }
        return modelAndView;
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public ModelAndView logout(ModelAndView modelAndView, HttpSession session) {
        modelAndView.addObject("nodeList", contextService.getNodeList());
        modelAndView.addObject("site", contextService.getSite());
        if (session.getAttribute("currentUserName") != null) {
            session.removeAttribute("currentUserName");
        }
        if (session.getAttribute("currentUser") != null) {
            session.removeAttribute("currentUser");
        }
        modelAndView.setViewName("redirect:/login.html");
        return modelAndView;
    }

}
