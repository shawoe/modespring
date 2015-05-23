package com.modespring.core.webapp;

import com.modespring.core.domain.User;
import com.modespring.core.service.UserService;
import com.modespring.core.webapp.access.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * Created by Shawoe on 2015/5/14.
 */
@Controller
@RequestMapping
public class UserCenterController extends BaseController {

    @Autowired
    public UserService userService;

    @RequestMapping(value = "center", method = RequestMethod.GET)
    public ModelAndView memberCenter(ModelAndView modelAndView, HttpSession session) {
        modelAndView.addObject("nodeList", Context.getNodeList());
        String username = (String) session.getAttribute("currentUserName");
        if (username == null) {
            modelAndView.setViewName("redirect:/login.html");
        } else {
            User user = userService.getByName(username);
            modelAndView.addObject("currentUser", user);
        }
        return modelAndView;
    }

}
