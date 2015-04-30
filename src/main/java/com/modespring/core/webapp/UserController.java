package com.modespring.core.webapp;

import static com.modespring.core.common.ExceptionMessage.*;
import com.modespring.core.domain.User;
import com.modespring.core.service.UserService;
import com.modespring.core.common.WebsiteContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    public WebsiteContext login(WebsiteContext website, HttpSession session) {
        if (session.getAttribute("currentUser") != null) {
            website.setViewName("redirect:memberCenter.html");
        }
        return website;
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public WebsiteContext loginAction(WebsiteContext website, HttpSession session, User user) {
        if (session.getAttribute("currentUser") != null) {
            website.setViewName("redirect:memberCenter.html");
        } else try {
            user = userService.login(user.getUsername(), user.getPassword());
            session.setAttribute("currentUser", user);
            website.setViewName("redirect:memberCenter.html");
        } catch (Exception e) {
            website.addObject("errorMessage", e.getMessage());
        }
        return website;
    }

    @RequestMapping(value = "memberCenter", method = RequestMethod.GET)
    public WebsiteContext memberCenter(WebsiteContext website, HttpSession session) {
        if (session.getAttribute("currentUser") == null) {
            website.addObject("errorMessage", USER_NOT_LOGIN_EXCEPTION);
            website.setViewName("/error");
        }
        return website;
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public WebsiteContext logout(WebsiteContext website, HttpSession session) {
        if (session.getAttribute("currentUser") != null) {
            User currentUser = (User) session.getAttribute("currentUser");
            userService.logout(currentUser);
            session.removeAttribute("currentUser");
            website.setViewName("redirect:login.html");
        } else {
            website.addObject("errorMessage", USER_NOT_LOGIN_EXCEPTION);
            website.setViewName("/error");
        }
        return website;
    }

    @RequestMapping(value = "register", method = RequestMethod.GET)
    public WebsiteContext register(WebsiteContext website, HttpSession session) {
        if (session.getAttribute("currentUser") != null) {
            website.addObject("errorMessage", USER_LOGGED_EXCEPTION);
            website.setViewName("/error");
        }
        return website;
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public WebsiteContext registerAction(WebsiteContext website, HttpSession session, User user) {
        if (session.getAttribute("currentUser") != null) {
            website.addObject("errorMessage", USER_LOGGED_EXCEPTION);
            website.setViewName("/error");
        } else try {
            userService.register(user);
            website.setViewName("redirect:login.html");
        } catch (Exception e) {
            website.addObject("errorMessage", e.getMessage());
        }
        return website;
    }

    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public WebsiteContext edit(WebsiteContext website, HttpSession session) {
        if (session.getAttribute("currentUser") == null) {
            website.addObject("errorMessage", USER_NOT_LOGIN_EXCEPTION);
            website.setViewName("/error");
        }
        return website;
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public WebsiteContext editAction(WebsiteContext website, HttpSession session, User user) {
        if (session.getAttribute("currentUser") == null) {
            website.addObject("errorMessage", USER_NOT_LOGIN_EXCEPTION);
            website.setViewName("/error");
        } else try {
            userService.editDetails(user);
            website.setViewName("redirect:memberCenter.html");
        } catch (Exception e) {
            website.addObject("errorMessage", e.getMessage());
        }
        return website;
    }

    @RequestMapping(value = "changePassword", method = RequestMethod.GET)
    public WebsiteContext changePassword(WebsiteContext website, HttpSession session) {
        if (session.getAttribute("currentUser") == null) {
            website.addObject("errorMessage", USER_NOT_LOGIN_EXCEPTION);
            website.setViewName("/error");
        }
        return website;
    }

    @RequestMapping(value = "changePassword", method = RequestMethod.POST)
    public WebsiteContext changePasswordAction(WebsiteContext website, HttpSession session, User user, String newPassword) {
        if (session.getAttribute("currentUser") == null) {
            website.addObject("errorMessage", USER_NOT_LOGIN_EXCEPTION);
            website.setViewName("/error");
        } else try {
            user = userService.login(user.getUsername(), user.getPassword());
            user.setPassword(newPassword);
            userService.editDetails(user);
            website.setViewName("redirect:memberCenter.html");
        } catch (Exception e) {
            website.addObject("errorMessage", e.getMessage());
        }
        return website;
    }
}
