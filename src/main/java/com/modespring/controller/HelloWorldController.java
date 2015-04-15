package com.modespring.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Shawoe on 2015/4/15.
 */
@Controller
public class HelloWorldController {
    @RequestMapping(value ="hello")
    public ModelAndView hello(String name, ModelAndView modelAndView) {
        modelAndView.addObject("name", name);
        return modelAndView;
    }
}