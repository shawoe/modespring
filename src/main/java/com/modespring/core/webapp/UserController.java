package com.modespring.core.webapp;

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

    @RequestMapping(value = "/hello.html", method = RequestMethod.GET)
    public ModelAndView hello(ModelAndView modelAndView, HttpServletRequest request) {
        modelAndView.addObject("name", request.getParameter("name"));
        return modelAndView;
    }

}
