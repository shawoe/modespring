package com.modespring.core.webapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Shawoe on 2015/4/24.
 */
@Controller
public class UserController {

//    @Autowired
//    public UserService userService;

    @RequestMapping(value = "/hello.html", method = RequestMethod.GET)
    public ModelAndView hello(String name, ModelAndView modelAndView) {
        modelAndView.addObject("name", name);
        return modelAndView;
    }

}
