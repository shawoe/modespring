package com.modespring.core.webapp;

import static com.modespring.core.common.ExceptionMessage.*;
import com.modespring.core.domain.User;
import com.modespring.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpSession;


/**
 * Created by Shawoe on 2015/4/24.
 */
@Controller
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    public UserService userService;

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public ModelAndView login(ModelAndView modelAndView, HttpSession session) {
        if (userService.isLogged(session)) {
            modelAndView.setViewName("redirect:memberCenter.html");
        }
        return modelAndView;
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ModelAndView loginAction(ModelAndView modelAndView, HttpSession session, String userName, String userPassword) {
        if (userService.isLogged(session)) {
            modelAndView.setViewName("redirect:memberCenter.html");
        } else try {
            User user = userService.login(userName, userPassword);
            session.setAttribute("currentUser", user);
            modelAndView.setViewName("redirect:memberCenter.html");
        } catch (Exception e) {
            modelAndView.addObject("errorMessage", e.getMessage());
        }
        return modelAndView;
    }

    @RequestMapping(value = "memberCenter", method = RequestMethod.GET)
    public ModelAndView memberCenter(ModelAndView modelAndView, HttpSession session) {
        if (userService.isLogged(session)) {
            modelAndView.addObject("user", session.getAttribute("currentUser"));
        } else {
            modelAndView.addObject("errorMessage", USER_NOT_LOGIN_EXCEPTION);
            modelAndView.setViewName("/error");
        }
        return modelAndView;
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public ModelAndView logout(ModelAndView modelAndView, HttpSession session) {
        if (userService.isLogged(session)) {
            userService.logout(session);
            modelAndView.setViewName("redirect:login.html");
        } else {
            modelAndView.addObject("errorMessage", USER_NOT_LOGIN_EXCEPTION);
            modelAndView.setViewName("/error");
        }
        return modelAndView;
    }

    @RequestMapping(value = "register", method = RequestMethod.GET)
    public ModelAndView register(ModelAndView modelAndView, HttpSession session) {
        if (userService.isLogged(session)) {
            modelAndView.addObject("errorMessage", USER_LOGGED_EXCEPTION);
            modelAndView.setViewName("/error");
        }
        return modelAndView;
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public ModelAndView registerAction(ModelAndView modelAndView, HttpSession session, String userName, String userPassword, String confirmPassword, String userEmail) {
        if (userService.isLogged(session)) {
            modelAndView.addObject("errorMessage", USER_LOGGED_EXCEPTION);
            modelAndView.setViewName("/error");
        } else try {
            userService.registerFormValidate(userName, userPassword,confirmPassword,userEmail);
            userService.register(userName, userPassword, userEmail);
            modelAndView.setViewName("redirect:login.html");
        } catch (Exception e) {
            modelAndView.addObject("errorMessage", e.getMessage());
        }
        return modelAndView;
    }
}
