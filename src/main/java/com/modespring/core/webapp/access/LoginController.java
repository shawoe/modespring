package com.modespring.core.webapp.access;

import com.modespring.core.domain.User;
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
public class LoginController extends BaseController {

    @Autowired
    public UserService userService;

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public ModelAndView login(ModelAndView modelAndView, HttpSession session) {
        modelAndView.addObject("nodeList", Context.getNodeList());
        if (session.getAttribute("currentUserName") != null) {
            modelAndView.setViewName("redirect:/center.html");
        }
        return modelAndView;
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ModelAndView loginAction(ModelAndView modelAndView, HttpSession session, User user) {
        modelAndView.addObject("nodeList",Context.getNodeList());
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
        modelAndView.addObject("nodeList",Context.getNodeList());
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
