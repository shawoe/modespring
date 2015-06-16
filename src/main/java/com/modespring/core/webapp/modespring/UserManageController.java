package com.modespring.core.webapp.modespring;

import com.modespring.core.domain.User;
import com.modespring.core.service.RoleService;
import com.modespring.core.service.UserService;
import com.modespring.core.webapp.access.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Shawoe on 2015/5/8.
 */
@Controller
@RequestMapping(value = "modespring")
public class UserManageController extends BaseController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "user", method = RequestMethod.GET)
    public ModelAndView getAll(ModelAndView modelAndView) {
        modelAndView.addObject("mospList", Context.getMospList());
        modelAndView.addObject("MospNodeName", "user");
        modelAndView.addObject("userList", userService.getAll());
        modelAndView.addObject("roleList", roleService.getAll());
        return modelAndView;
    }

    @RequestMapping(value = "user", method = RequestMethod.PUT)
    public ModelAndView create(ModelAndView modelAndView, User user) {
        try {
            userService.register(user);
        } catch (Exception e) {
            modelAndView.addObject("errorMessage", e.getMessage());
        }
        modelAndView.setViewName("redirect:/modespring/user.html");
        return modelAndView;
    }

    @RequestMapping(value = "user/{username}", method = RequestMethod.GET)
    public ModelAndView getUserDetails(ModelAndView modelAndView, @PathVariable String username) {
        modelAndView.addObject("mospList", Context.getMospList());
        modelAndView.addObject("MospNodeName", "user");
        modelAndView.setViewName("modespring/userDetails");
        modelAndView.addObject("user", userService.getByName(username));
        return modelAndView;
    }

    @RequestMapping(value = "user", method = RequestMethod.DELETE)
    public ModelAndView editAll(ModelAndView modelAndView, Integer[] delete) {
        try {
            userService.deleteAll(delete);
        } catch (Exception e) {
            e.printStackTrace();
        }
        modelAndView.setViewName("redirect:/modespring/user.html");
        return modelAndView;
    }

}


