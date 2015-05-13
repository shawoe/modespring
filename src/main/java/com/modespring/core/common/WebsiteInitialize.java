package com.modespring.core.common;

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
public class WebsiteInitialize {

    private static boolean isFirstOpen = true;

    @Autowired
    protected WebsiteContext Context;

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

            // save power
            List<Power> powerList = new ArrayList<Power>();
            Power power = new Power();
            power.setName("栏目管理");
            powerList.add(power);
            powerDao.save(powerList);

            // save role
            List<Role> roleList = new ArrayList<Role>();
            Role role_admin = new Role();
            role_admin.setName("管理员");
            role_admin.setPower(100);
            role_admin.setPowerList(powerList);
            roleList.add(role_admin);
            Role role_user = new Role();
            role_user.setName("注册用户");
            role_user.setPower(10);
            roleList.add(role_user);
            roleDao.save(roleList);

            // save user
            List<User> user_list = new ArrayList<User>();
            User user_shawoe = new User();
            user_shawoe.setName("shawoe");
            user_shawoe.setPassword("shawoe");
            user_shawoe.setEmail("shawoe@modespring.com");
            user_shawoe.setRole(role_admin);
            user_list.add(user_shawoe);
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

            // save node
            Node root_node = new Node();
            root_node.setName("首页");
            nodeDao.save(root_node);
            List<Node> parent_list = new ArrayList<Node>();
            List<Node> child_list = new ArrayList<Node>();
            for (int i = 0; i < 3; i++) {
                Node parent_node = new Node(root_node);
                parent_node.setName("栏目分类" + i);
                parent_list.add(parent_node);
                for (int j = 0; j < 2; j++) {
                    Node child_node = new Node(parent_node);
                    child_node.setName("新栏目" + j);
                    child_list.add(child_node);
                }
            }
            nodeDao.save(parent_list);
            nodeDao.save(child_list);
            Context.flush();


            // save field
            List<Field> field_list = new ArrayList<Field>();
            for (int i = 0; i < 3; i++) {
                Field field = new Field();
                field.setName("新增字段" + i);
                field_list.add(field);
            }
            List<Field> fields = fieldDao.save(field_list);

            // save article
            List<Article> article_list = new ArrayList<Article>();
            for (int i = 0; i < 5; i++) {
                Article article = new Article();
                article.setTitle("新文章" + i);
                article.setFieldList(fields);
                article_list.add(article);
            }
            articleDao.save(article_list);






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
