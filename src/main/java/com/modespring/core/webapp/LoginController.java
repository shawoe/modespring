package com.modespring.core.webapp;

import com.modespring.core.domain.User;
import com.modespring.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpSession;
import static com.modespring.core.common.ExceptionMessage.USER_NOT_LOGIN_EXCEPTION;

/**
 * Created by Shawoe on 2015/5/12.
 */
@Controller
@RequestMapping
public class LoginController extends BaseController {

    @Autowired
    public UserService userService;

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public ModelAndView login(ModelAndView modelAndView, HttpSession session) {
        modelAndView.addObject("nodeList", Context.getNodeList());
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
            user = userService.login(user.getName(), user.getPassword());
            session.setAttribute("currentUserId", user.getId());
            session.setAttribute("currentUser", user.getName());
//            session.setAttribute("currentPower", user.getRole().getPower());
            modelAndView.setViewName("redirect:memberCenter.html");
        } catch (Exception e) {
            modelAndView.addObject("errorMessage", e.getMessage());
        }
        return modelAndView;
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public ModelAndView logout(ModelAndView modelAndView, HttpSession session) {
        modelAndView.addObject("nodeList",Context.getNodeList());
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

}
