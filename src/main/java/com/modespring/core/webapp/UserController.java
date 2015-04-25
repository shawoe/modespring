package com.modespring.core.webapp;

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
        modelAndView.addObject("userName", request.getParameter("userName"));
        return modelAndView;
    }

    @RequestMapping(value = "/loginAction.html", method = RequestMethod.GET)
    public ModelAndView loginAction(HttpServletRequest request) {
        String userName = request.getParameter("userName");
        String userPassword = request.getParameter("userPassword");
        ModelAndView modelAndView = new ModelAndView("/login");
        try {
            User user = userService.loginUser(userName,userPassword);
            modelAndView.setViewName("/user/memberCenter");
            modelAndView.addObject("user", user);
        } catch (Exception e) {
            modelAndView.addObject("errorMessage", e.getMessage());
        }
        return modelAndView;
    }

}
