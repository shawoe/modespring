package com.modespring.core.webapp;

import com.modespring.core.domain.User;
import com.modespring.core.service.ContextService;
import com.modespring.core.service.UserService;
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
public class ModeSpringController {

    @Autowired
    protected ContextService contextService;

    @Autowired
    public UserService userService;

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public ModelAndView getOne(ModelAndView modelAndView) {
        modelAndView.setViewName("redirect:/modespring/login.html");
        return modelAndView;
    }

    @RequestMapping(value = "{name}", method = RequestMethod.GET)
    public ModelAndView center(ModelAndView modelAndView, HttpSession session, @PathVariable String name) {
        modelAndView.addObject("mospList", contextService.getMospList());
        modelAndView.addObject("site", contextService.getSite());
        modelAndView.addObject("MospNodeName", name);
        User user = (User) session.getAttribute("ModeSpringUser");
        if (user == null) {
            modelAndView.setViewName("redirect:/modespring/login.html");
        }
        return modelAndView;
    }

}
