package com.modespring.core.webapp;

import static com.modespring.core.common.ExceptionMessage.*;
import com.modespring.core.domain.User;
import com.modespring.core.service.UserService;
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
@RequestMapping
public class UserController extends BaseController {

    @Autowired
    public UserService userService;

    @RequestMapping(value = "memberCenter", method = RequestMethod.GET)
    public ModelAndView memberCenter(ModelAndView modelAndView, HttpSession session) {
        modelAndView.addObject("nodeList",Context.getNodeList());
        String username = (String) session.getAttribute("currentUser");
        if (username == null) {
            modelAndView.addObject("errorMessage", USER_NOT_LOGIN_EXCEPTION);
            modelAndView.setViewName("/error");
        } else {
            User currentUser = userService.getDetailsByUsername(username);
            modelAndView.addObject("currentUser", currentUser);
        }
        return modelAndView;
    }

    @RequestMapping(value = "register", method = RequestMethod.GET)
    public ModelAndView register(ModelAndView modelAndView, HttpSession session) {
        modelAndView.addObject("nodeList",Context.getNodeList());
        if (session.getAttribute("currentUser") != null) {
            modelAndView.addObject("errorMessage", USER_LOGGED_EXCEPTION);
            modelAndView.setViewName("/error");
        }
        return modelAndView;
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public ModelAndView registerAction(ModelAndView modelAndView, HttpSession session, User user) {
        if (session.getAttribute("currentUser") != null) {
            modelAndView.addObject("errorMessage", USER_LOGGED_EXCEPTION);
            modelAndView.setViewName("/error");
        } else try {
            userService.register(user);
            modelAndView.setViewName("redirect:login.ftl");
        } catch (Exception e) {
            modelAndView.addObject("errorMessage", e.getMessage());
        }
        return modelAndView;
    }

    @RequestMapping(value = "user_{id}", method = RequestMethod.GET)
    public ModelAndView edit(ModelAndView modelAndView, HttpSession session, @PathVariable Integer id) {
        modelAndView.addObject("nodeList",Context.getNodeList());
        String username = (String) session.getAttribute("currentUser");
        if (username == null) {
            modelAndView.addObject("errorMessage", USER_NOT_LOGIN_EXCEPTION);
            modelAndView.setViewName("/error");
        } else {
            User currentUser = userService.getDetailsByUsername(username);
            modelAndView.addObject("currentUser", currentUser);
            modelAndView.setViewName("/user/edit");
        }
        return modelAndView;
    }

    @RequestMapping(value = "user_{id}", method = RequestMethod.POST)
    public ModelAndView editAction(ModelAndView modelAndView, HttpSession session, @PathVariable Integer id, User user, String newPassword) {
        if (session.getAttribute("currentUser") == null) {
            modelAndView.addObject("errorMessage", USER_NOT_LOGIN_EXCEPTION);
            modelAndView.setViewName("/error");
        } else try {
            User currentUser = userService.login(user.getName(), user.getPassword());
            user.setId(currentUser.getId());
            if (!newPassword.isEmpty()){
                user.setPassword(newPassword);
            }
            userService.updateDetails(user);
            modelAndView.setViewName("redirect:memberCenter.html");
        } catch (Exception e) {
            modelAndView.addObject("errorMessage", e.getMessage());
        }
        return modelAndView;
    }

    @RequestMapping(value = "changePassword", method = RequestMethod.GET)
    public ModelAndView changePassword(ModelAndView modelAndView, HttpSession session) {
        modelAndView.addObject("nodeList",Context.getNodeList());
        if (session.getAttribute("currentUser") == null) {
            modelAndView.addObject("errorMessage", USER_NOT_LOGIN_EXCEPTION);
            modelAndView.setViewName("/error");
        }
        return modelAndView;
    }

    @RequestMapping(value = "changePassword", method = RequestMethod.POST)
    public ModelAndView changePasswordAction(ModelAndView modelAndView, HttpSession session, User user, String newPassword) {
        if (session.getAttribute("currentUser") == null) {
            modelAndView.addObject("errorMessage", USER_NOT_LOGIN_EXCEPTION);
            modelAndView.setViewName("/error");
        } else try {
            user = userService.login(user.getName(), user.getPassword());
            user.setPassword(newPassword);
            userService.updateDetails(user);
            modelAndView.setViewName("redirect:memberCenter.html");
        } catch (Exception e) {
            modelAndView.addObject("errorMessage", e.getMessage());
        }
        return modelAndView;
    }
}
