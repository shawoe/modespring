package com.modespring.core.webapp;

import com.modespring.core.domain.bean.BaseBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * Created by Shawoe on 2015/5/22.
 */
@Controller
@RequestMapping
public class IndexController extends BaseBean {

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public ModelAndView index(ModelAndView modelAndView, HttpSession session) {
        modelAndView.setViewName("redirect:/focus.html");
        return modelAndView;
    }
}
