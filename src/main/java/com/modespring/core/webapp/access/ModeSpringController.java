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
 * Created by Shawoe on 2015/5/15.
 */
@Controller
@RequestMapping(value = "modespring")
public class ModeSpringController extends BaseController {

    @Autowired
    public UserService userService;

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public ModelAndView loginModeSpring(ModelAndView modelAndView, HttpSession session) {
        modelAndView.addObject("nodeList", Context.getNodeList());
        if (session.getAttribute("currentUser") != null) {
            modelAndView.setViewName("redirect:/modespring/center.html");
        }
        return modelAndView;
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ModelAndView loginModeSpringAction(ModelAndView modelAndView, HttpSession session, User user) {
        if (session.getAttribute("currentUser") != null) {
            modelAndView.setViewName("redirect:/modespring/center.html");
        } else try {
            user = userService.login(user.getName(), user.getPassword());
            session.setAttribute("currentUserId", user.getId());
            session.setAttribute("currentUser", user.getName());
            modelAndView.setViewName("redirect:/modespring/center.html");
        } catch (Exception e) {
            modelAndView.addObject("errorMessage", e.getMessage());
        }
        return modelAndView;
    }

}
