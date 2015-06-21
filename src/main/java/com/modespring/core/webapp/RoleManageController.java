package com.modespring.core.webapp;

import com.modespring.core.domain.Role;
import com.modespring.core.service.ContextService;
import com.modespring.core.service.RoleService;
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
public class RoleManageController {

    @Autowired
    protected ContextService contextService;

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "role", method = RequestMethod.GET)
    public ModelAndView getAll(ModelAndView modelAndView) {
        modelAndView.addObject("mospList", contextService.getMospList());
        modelAndView.addObject("MospNodeName", "role");
        modelAndView.addObject("roleList", roleService.getAll());
        return modelAndView;
    }

    @RequestMapping(value = "role", method = RequestMethod.PUT)
    public ModelAndView create(ModelAndView modelAndView, Role role) {
        roleService.create(role);
        modelAndView.setViewName("redirect:/modespring/role.html");
        return modelAndView;
    }

    @RequestMapping(value = "role/{name}", method = RequestMethod.GET)
    public ModelAndView getUserDetails(ModelAndView modelAndView, @PathVariable String name) {
        modelAndView.addObject("mospList", contextService.getMospList());
        modelAndView.addObject("MospNodeName", "role");
        modelAndView.setViewName("modespring/roleDetails");
        modelAndView.addObject("role", roleService.getByName(name));
        return modelAndView;
    }

}


