package com.modespring.core.webapp.access;

import com.modespring.core.domain.pojo.Site;
import com.modespring.core.service.SiteService;
import org.apache.commons.configuration.ConfigurationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Shawoe on 2015/5/1.
 */
@Controller
@RequestMapping(value = "modespring")
public class SiteInitController {

    private static boolean isFirstOpen = true;

    @Autowired
    protected SiteService siteService;

    @RequestMapping(value = "init", method = RequestMethod.GET)
    public ModelAndView init(ModelAndView modelAndView) {
        modelAndView.setViewName("/modespring/init");
        return modelAndView;
    }

    @RequestMapping(value = "init", method = RequestMethod.POST)
    public ModelAndView initAction(ModelAndView modelAndView, Site site, String username, String password, String email) throws ConfigurationException {
        if (isFirstOpen) {
            isFirstOpen = false;
            siteService.init(site,username,password,email);
            modelAndView.addObject("msg", "ModeSpring1.0 初始化成功！！");
        } else {
            modelAndView.addObject("msg", "ModeSpring1.0 已经初始化！！");
        }
        modelAndView.setViewName("/warn");
        return modelAndView;
    }


}
