package com.modespring.core.common;

import com.modespring.core.domain.Node;
import com.modespring.core.domain.Role;
import com.modespring.core.domain.User;
import com.modespring.core.repository.NodeDao;
import com.modespring.core.repository.RoleDao;
import com.modespring.core.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shawoe on 2015/5/1.
 */
@Controller
@RequestMapping(value = "modespring")
public class WebsiteInitialize {

    private static boolean isFirstOpen = true;

    @Autowired
    private UserDao userDao;

    @Autowired
    private NodeDao nodeDao;

    @Autowired
    private RoleDao roleDao;

    @RequestMapping(value = "error", method = RequestMethod.GET)
    public ModelAndView init(ModelAndView modelAndView) {
        if (isFirstOpen) {

            // save role
            List<Role> roleList = new ArrayList<Role>();
            Role role_admin = new Role();
            role_admin.setName("管理员");
            role_admin.setPower(100);
            roleList.add(role_admin);
            Role role_user = new Role();
            role_user.setName("注册用户");
            role_user.setPower(10);
            roleList.add(role_user);
            roleDao.save(roleList);

            // save user
            User user = new User();
            user.setUsername("admin");
            user.setPassword("admin");
            user.setEmail("admin@modespring.com");
            userDao.save(user);

            // save node
            List<Node> nodeList = new ArrayList<Node>();
            for (int i = 0; i < 3; i++) {
                Node node = new Node();
                node.setTitle("新栏目" + i);
                nodeList.add(node);
            }
            List<Node> parentList = nodeDao.save(nodeList);
            nodeDao.flush();
            List<Node> childList = new ArrayList<Node>();
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 2; k++) {
                    Node childNode = new Node();
                    childNode.setTitle("子栏目" + j + k);
                    childNode.setParentNode(parentList.get(j));
                    childList.add(childNode);
                }
            }
            nodeDao.save(childList);




            // success
            isFirstOpen = false;
            modelAndView.addObject("errorMessage", "ModeSpring1.0 初始化成功！！");
        } else {
            modelAndView.addObject("errorMessage", "ModeSpring1.0 已经初始化！！");
        }
        modelAndView.setViewName("/error");
        return modelAndView;
    }


}
