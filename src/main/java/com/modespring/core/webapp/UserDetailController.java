package com.modespring.core.webapp;

import com.modespring.core.common.FileUploadUtil;
import com.modespring.core.domain.Node;
import com.modespring.core.domain.User;
import com.modespring.core.service.ContextService;
import com.modespring.core.service.NodeService;
import com.modespring.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;


/**
 * Created by Shawoe on 2015/4/24.
 */
@Controller
@RequestMapping(value = "user")
public class UserDetailController {

    @Autowired
    protected ContextService contextService;

    @Autowired
    private NodeService nodeService;

    @Autowired
    public UserService userService;

    @RequestMapping(value = "{name}", method = RequestMethod.GET)
    public ModelAndView edit(ModelAndView modelAndView, HttpSession session, @PathVariable String name) {
        modelAndView.addObject("nodeList", contextService.getNodeList());
        modelAndView.addObject("site", contextService.getSite());
        String username = (String) session.getAttribute("currentUserName");
        Node node = nodeService.getByName("member");
        modelAndView.addObject("node", node);
        if (username == null) {
            modelAndView.setViewName("redirect:/login.html");
        } else {
            User currentUser = userService.getByName(username);
            modelAndView.addObject("currentUser", currentUser);
            modelAndView.setViewName("profile");
        }
        return modelAndView;
    }

    @RequestMapping(value = "{name}", method = RequestMethod.POST)
    public ModelAndView editAction(ModelAndView modelAndView, HttpSession session, @PathVariable String name, @RequestParam MultipartFile avatarFile, User user, String newPassword) {
        String username = (String) session.getAttribute("currentUserName");
        if (username != null && !username.equals(name)) {
            modelAndView.setViewName("redirect:/login.html");
        } else try {
            User currentUser = userService.login(user.getName(), user.getPassword());
            user.setId(currentUser.getId());
            if (!newPassword.isEmpty()) {
                user.setPassword(newPassword);
            }
            if (avatarFile != null) {
                String realPath = session.getServletContext().getRealPath("/images");
                String fileName = FileUploadUtil.uploadFile(avatarFile, realPath);
                user.setAvatar("/images/" + fileName);
            }
            userService.updateDetails(user);
            modelAndView.setViewName("redirect:/center.html");
        } catch (Exception e) {
            modelAndView.setViewName("redirect:/login.html");
        }
        return modelAndView;
    }

}
