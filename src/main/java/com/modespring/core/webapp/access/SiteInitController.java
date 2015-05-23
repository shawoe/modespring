package com.modespring.core.webapp.access;

import com.modespring.core.service.singleton.ContextService;
import com.modespring.core.domain.*;
import com.modespring.core.repository.*;
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
public class SiteInitController {

    private static boolean isFirstOpen = true;

    @Autowired
    protected ContextService Context;

    @Autowired
    private PowerDao powerDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private NodeDao nodeDao;

    @Autowired
    private FieldDao fieldDao;

    @Autowired
    private ArticleDao articleDao;


    @RequestMapping(value = "error", method = RequestMethod.GET)
    public ModelAndView init(ModelAndView modelAndView) {
        if (isFirstOpen) {

            // 添加权限
            List<Power> powerList = new ArrayList<Power>();
            Power power_node = new Power();
            power_node.setName("node");
            power_node.setTitle("栏目管理");
            powerList.add(power_node);

            Power power_article = new Power();
            power_article.setName("article");
            power_article.setTitle("文章管理");
            powerList.add(power_article);

            Power power_user = new Power();
            power_user.setName("user");
            power_user.setTitle("用户管理");
            powerList.add(power_user);
            powerDao.save(powerList);

            // 添加角色
            List<Role> roleList = new ArrayList<Role>();
            Role role_admin = new Role();
            role_admin.setName("admin");
            role_admin.setTitle("管理员");
            role_admin.setPower(100);
            role_admin.setPowerList(powerList);
            roleList.add(role_admin);

            Role role_user = new Role();
            role_user.setName("user");
            role_user.setTitle("注册用户");
            role_user.setPower(10);
            roleList.add(role_user);
            roleDao.save(roleList);

            // 添加用户
            List<User> user_list = new ArrayList<User>();
            User user_modespring = new User();
            user_modespring.setName("modespring");
            user_modespring.setPassword("modespring");
            user_modespring.setEmail("modespring@modespring.com");
            user_modespring.setRole(role_admin);
            user_list.add(user_modespring);

            User user_admin = new User();
            user_admin.setName("admin");
            user_admin.setPassword("admin");
            user_admin.setEmail("admin@modespring.com");
            user_admin.setRole(role_admin);
            user_list.add(user_admin);
            userDao.save(user_list);

            // 添加栏目
            Node node_global = new Node();
            node_global.setName("global");
            node_global.setTitle("首页");
            nodeDao.save(node_global);

            List<Node> nodeList = new ArrayList<Node>();
            List<Node> childList = new ArrayList<Node>();
            Node node_focus = new Node(node_global);
            node_focus.setName("focus");
            node_focus.setTitle("推荐");
            nodeList.add(node_focus);
            for (int i = 0; i < 2; i++) {
                Node child_node = new Node(node_focus);
                child_node.setName("focus" + i);
                child_node.setTitle("推荐分类" + i);
                childList.add(child_node);
            }

            Node node_guide = new Node(node_global);
            node_guide.setName("guide");
            node_guide.setTitle("导购");
            nodeList.add(node_guide);
            for (int i = 0; i < 2; i++) {
                Node child_node = new Node(node_guide);
                child_node.setName("guide" + i);
                child_node.setTitle("导购分类" + i);
                childList.add(child_node);
            }

            Node node_rent = new Node(node_global);
            node_rent.setName("rent");
            node_rent.setTitle("租车");
            nodeList.add(node_rent);
            for (int i = 0; i < 3; i++) {
                Node child_node = new Node(node_rent);
                child_node.setName("rent" + i);
                child_node.setTitle("租车分类" + i);
                childList.add(child_node);
            }
            nodeDao.save(nodeList);
            nodeDao.save(childList);

            // 添加字段
            List<Field> fieldList = new ArrayList<Field>();
            for (int i = 0; i < 3; i++) {
                Field field = new Field();
                field.setName("field" + i);
                field.setTitle("新增字段" + i);
                fieldList.add(field);
            }
            fieldDao.save(fieldList);

            // 添加文章
            List<Article> articleList = new ArrayList<Article>();
            for (int i = 0; i < 5; i++) {
                Article article = new Article(node_focus);
                article.setName("focus" + i);
                article.setTitle("推荐文章" + i);
                article.setFieldList(fieldList);
                articleList.add(article);
            }
            articleDao.save(articleList);

            // 初始化成功
            isFirstOpen = false;
            modelAndView.addObject("errorMessage", "ModeSpring1.0 初始化成功！！");
        } else {
            modelAndView.addObject("errorMessage", "ModeSpring1.0 已经初始化！！");
        }
        modelAndView.setViewName("/error");
        return modelAndView;
    }


}
