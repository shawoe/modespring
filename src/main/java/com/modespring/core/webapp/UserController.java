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
public class UserController extends BaseController {

    @Autowired
    public UserService userService;

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public ModelAndView login(ModelAndView modelAndView, HttpSession session) {
        if (session.getAttribute("currentUser") != null) {
            modelAndView.setViewName("redirect:memberCenter.html");
        }
        return modelAndView;
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ModelAndView loginAction(ModelAndView modelAndView, HttpSession session, User user) {
        if (session.getAttribute("currentUser") != null) {
            modelAndView.setViewName("redirect:memberCenter.html");
        } else try {
            user = userService.login(user.getUsername(), user.getPassword());
            session.setAttribute("currentUser", user.getUsername());
            session.setAttribute("currentPower", user.getRole().getPower());
            modelAndView.setViewName("redirect:memberCenter.html");
        } catch (Exception e) {
            modelAndView.addObject("errorMessage", e.getMessage());
        }
        return modelAndView;
    }

    @RequestMapping(value = "memberCenter", method = RequestMethod.GET)
    public ModelAndView memberCenter(ModelAndView modelAndView, HttpSession session) {
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

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public ModelAndView logout(ModelAndView modelAndView, HttpSession session) {
        if (session.getAttribute("currentUser") != null) {
            String currentUser = (String) session.getAttribute("currentUser");
            userService.logout(currentUser);
            session.removeAttribute("currentUser");
            session.removeAttribute("currentPower");
            modelAndView.setViewName("redirect:login.html");
        } else {
            modelAndView.addObject("errorMessage", USER_NOT_LOGIN_EXCEPTION);
            modelAndView.setViewName("/error");
        }
        return modelAndView;
    }

    @RequestMapping(value = "register", method = RequestMethod.GET)
    public ModelAndView register(ModelAndView modelAndView, HttpSession session) {
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
            modelAndView.setViewName("redirect:login.html");
        } catch (Exception e) {
            modelAndView.addObject("errorMessage", e.getMessage());
        }
        return modelAndView;
    }

    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public ModelAndView edit(ModelAndView modelAndView, HttpSession session) {
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

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public ModelAndView editAction(ModelAndView modelAndView, HttpSession session, User user, String newPassword) {
        if (session.getAttribute("currentUser") == null) {
            modelAndView.addObject("errorMessage", USER_NOT_LOGIN_EXCEPTION);
            modelAndView.setViewName("/error");
        } else try {
            User currentUser = userService.login(user.getUsername(), user.getPassword());
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
            user = userService.login(user.getUsername(), user.getPassword());
            user.setPassword(newPassword);
            userService.updateDetails(user);
            modelAndView.setViewName("redirect:memberCenter.html");
        } catch (Exception e) {
            modelAndView.addObject("errorMessage", e.getMessage());
        }
        return modelAndView;
    }
}
