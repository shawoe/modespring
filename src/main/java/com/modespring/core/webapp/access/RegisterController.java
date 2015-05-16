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
@RequestMapping
public class RegisterController extends BaseController {

        @Autowired
        public UserService userService;

        @RequestMapping(value = "register", method = RequestMethod.GET)
        public ModelAndView register(ModelAndView modelAndView, HttpSession session) {
            modelAndView.addObject("nodeList",Context.getNodeList());
            if (session.getAttribute("currentUser") != null) {
                modelAndView.setViewName("redirect:/user/center.html");
                modelAndView.setViewName("/error");
            }
            return modelAndView;
        }

        @RequestMapping(value = "register", method = RequestMethod.POST)
        public ModelAndView registerAction(ModelAndView modelAndView, HttpSession session, User user) {
            if (session.getAttribute("currentUser") != null) {
                modelAndView.setViewName("redirect:/user/center.html");
            } else try {
                userService.register(user);
                modelAndView.setViewName("redirect:login.ftl");
            } catch (Exception e) {
                modelAndView.addObject("errorMessage", e.getMessage());
            }
            return modelAndView;
        }
}
