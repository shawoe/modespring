package com.modespring.core.webapp.modespring;

import com.modespring.core.domain.User;
import com.modespring.core.service.UserService;
import com.modespring.core.webapp.access.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * Created by Shawoe on 2015/5/16.
 */
@Controller
@RequestMapping(value = "modespring")
public class ModeSpringController extends BaseController {

    @Autowired
    public UserService userService;

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public ModelAndView getOne(ModelAndView modelAndView, HttpSession session) {
        modelAndView.setViewName("redirect:/modespring/login.html");
        return modelAndView;
    }

    @RequestMapping(value = "{name}", method = RequestMethod.GET)
    public ModelAndView center(ModelAndView modelAndView, HttpSession session, @PathVariable String name) {
        modelAndView.addObject("mospList", Context.getMospList());
        modelAndView.addObject("MospNodeName", name);
        User user = (User) session.getAttribute("ModeSpringUser");
        if (user == null) {
            modelAndView.setViewName("redirect:/modespring/login.html");
        }
        return modelAndView;
    }

}
