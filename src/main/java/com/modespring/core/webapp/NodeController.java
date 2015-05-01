package com.modespring.core.webapp;

import com.modespring.core.service.impl.WebsiteContext;
import com.modespring.core.service.NodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpSession;
import static com.modespring.core.common.ExceptionMessage.USER_NOT_LOGIN_EXCEPTION;

/**
 * Created by Shawoe on 2015/5/1.
 */
@Controller
@RequestMapping(value = "admin")
public class NodeController {

    @Autowired
    public NodeService nodeService;
    @Autowired
    WebsiteContext context;

    @RequestMapping(value = "node", method = RequestMethod.GET)
    public ModelAndView login(ModelAndView modelAndView, HttpSession session) {
//        if (session.getAttribute("currentUser") == null) {
//            modelAndView.addObject("errorMessage", USER_NOT_LOGIN_EXCEPTION);
//            modelAndView.setViewName("/error");
//        }
        modelAndView.addObject("nodeList", context.getNodeList());
        return modelAndView;
    }

}
