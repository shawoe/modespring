package com.modespring.core.webapp;

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
 * Created by Shawoe on 2015/4/24.
 */
@Controller
@RequestMapping(value = "user")
public class UserDetailController extends BaseController {

    @Autowired
    public UserService userService;

    @RequestMapping(value = "{name}", method = RequestMethod.GET)
    public ModelAndView edit(ModelAndView modelAndView, HttpSession session, @PathVariable String name) {
        modelAndView.addObject("nodeList", Context.getNodeList());
        String username = (String) session.getAttribute("currentUserName");
        if (username == null) {
            modelAndView.setViewName("redirect:/login.html");
        } else {
            User currentUser = userService.getByName(username);
            modelAndView.addObject("currentUser", currentUser);
            modelAndView.setViewName("profile");
        }
        return modelAndView;
    }

    @RequestMapping(value = "{name}", method = RequestMethod.POST)
    public ModelAndView editAction(ModelAndView modelAndView, HttpSession session, @PathVariable String name, User user, String newPassword) {
        String username = (String) session.getAttribute("currentUserName");
        if (username != null && !username.equals(name)) {
            modelAndView.setViewName("redirect:/login.html");
        } else try {
            User currentUser = userService.login(user.getName(), user.getPassword());
            user.setId(currentUser.getId());
            if (!newPassword.isEmpty()) {
                user.setPassword(newPassword);
            }
            userService.updateDetails(user);
            modelAndView.setViewName("redirect:/center.html");
        } catch (Exception e) {
            modelAndView.setViewName("redirect:/login.html");
        }
        return modelAndView;
    }

}
