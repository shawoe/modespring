package com.modespring.core.webapp;

import static com.modespring.core.common.ExceptionMessage.*;
import com.modespring.core.domain.User;
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
        if (userService.isUserLogged(request)) {
            modelAndView.addObject("errorMessage", USER_LOGGED_EXCEPTION);
            modelAndView.setViewName("/error");
        } else {
            modelAndView.setViewName("/user/login");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/loginAction.html", method = RequestMethod.POST)
    public ModelAndView loginAction(HttpServletRequest request) {
        String userName = request.getParameter("userName");
        String userPassword = request.getParameter("userPassword");
        ModelAndView modelAndView = new ModelAndView("/user/login");
        try {
            User user = userService.loginUser(userName,userPassword);
            request.getSession().setAttribute("currentUser", user);
            modelAndView.setViewName("redirect:/memberCenter.html");
        } catch (Exception e) {
            modelAndView.addObject("errorMessage", e.getMessage());
        }
        return modelAndView;
    }

    @RequestMapping(value = "/memberCenter.html", method = RequestMethod.GET)
    public ModelAndView memberCenter(ModelAndView modelAndView, HttpServletRequest request) {
        if (userService.isUserLogged(request)) {
            modelAndView.setViewName("/user/memberCenter");
            modelAndView.addObject("user", request.getSession().getAttribute("currentUser"));
        } else {
            modelAndView.addObject("errorMessage", USER_NOT_LOGIN_EXCEPTION);
            modelAndView.setViewName("/error");
        }
        return modelAndView;
    }

}
