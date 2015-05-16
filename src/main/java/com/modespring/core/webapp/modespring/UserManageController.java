package com.modespring.core.webapp.modespring;

import com.modespring.core.domain.User;
import com.modespring.core.service.RoleService;
import com.modespring.core.service.UserService;
import com.modespring.core.webapp.access.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpSession;

/**
 * Created by Shawoe on 2015/5/8.
 */
@Controller
@RequestMapping(value = "modespring")
public class UserManageController extends BaseController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "user", method = RequestMethod.GET)
    public ModelAndView getAll(ModelAndView modelAndView, HttpSession session) {
        modelAndView.addObject("userList", userService.getAll());
        modelAndView.addObject("roleList", roleService.getAll());
        return modelAndView;
    }

    @RequestMapping(value = "user", method = RequestMethod.PUT)
    public ModelAndView create(ModelAndView modelAndView, HttpSession session, User user) {
        try {
            userService.register(user);
        } catch (Exception e) {
            modelAndView.addObject("errorMessage", e.getMessage());
        }
        modelAndView.setViewName("redirect:/admin/user.html");
        return modelAndView;
    }

    @RequestMapping(value = "user/{username}", method = RequestMethod.GET)
    public ModelAndView getUserDetails(ModelAndView modelAndView, HttpSession session, @PathVariable String username) {
        modelAndView.setViewName("admin/userDetails");
        modelAndView.addObject("user", userService.getByName(username));
        return modelAndView;
    }

//    @RequestMapping(value = "node", method = RequestMethod.POST)
//    public ModelAndView editAll(ModelAndView modelAndView, HttpSession session, Integer[] id, String[] title, Integer[] parentId, Integer[] delete) throws UnsupportedEncodingException {
//        List<Node> nodeList = new ArrayList<Node>();
//        for (int i = 0; i < id.length; i++) {
//            Node node = nodeService.getOne(id[i]);
//            node.setTitle(title[i]);
//            if (parentId[i] > 0) {
//                Node parentNode = nodeService.getOne(parentId[i]);
//                node.setLevel(parentNode.getLevel() + 1);
//                node.setParentNode(parentNode);
//            }
//            nodeList.add(node);
//        }
//        nodeService.updateALL(nodeList);
//        for (int i = 0; delete != null && i < delete.length; i++) {
//            nodeService.delete(delete[i]);
//        }
//        Context.flush();
//        modelAndView.addObject("nodeList", Context.getNodeList());
//        return modelAndView;
//    }

}


