package com.modespring.core.webapp;

import static com.modespring.core.common.ExceptionMessage.*;

import com.modespring.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


/**
 * Created by Shawoe on 2015/4/24.
 */
@Controller
public class UserController {

    @Autowired
    public UserService userService;

    @RequestMapping(value = "/login.html", method = RequestMethod.GET)
    public ModelAndView login(ModelAndView modelAndView, HttpServletRequest request) {
        if (userService.isLogged(request)) {
            modelAndView.addObject("errorMessage", USER_LOGGED_EXCEPTION);
            modelAndView.setViewName("/error");
        } else {
            modelAndView.setViewName("/user/login");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/loginAction.html", method = RequestMethod.POST)
    public ModelAndView loginAction(ModelAndView modelAndView, HttpServletRequest request) {
        modelAndView.setViewName("/user/login");
        try {
            userService.login(request);
            modelAndView.setViewName("redirect:/memberCenter.html");
        } catch (Exception e) {
            modelAndView.addObject("errorMessage", e.getMessage());
        }
        return modelAndView;
    }

    @RequestMapping(value = "/memberCenter.html", method = RequestMethod.GET)
    public ModelAndView memberCenter(ModelAndView modelAndView, HttpServletRequest request) {
        if (userService.isLogged(request)) {
            modelAndView.setViewName("/user/memberCenter");
            modelAndView.addObject("user", request.getSession().getAttribute("currentUser"));
        } else {
            modelAndView.addObject("errorMessage", USER_NOT_LOGIN_EXCEPTION);
            modelAndView.setViewName("/error");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/logout.html", method = RequestMethod.GET)
    public ModelAndView logout(ModelAndView modelAndView, HttpServletRequest request) {
        if (userService.isLogged(request)) {
            userService.logout(request);
            modelAndView.setViewName("redirect:/login.html");
        } else {
            modelAndView.addObject("errorMessage", USER_NOT_LOGIN_EXCEPTION);
            modelAndView.setViewName("/error");
        }
        return modelAndView;
    }

}
