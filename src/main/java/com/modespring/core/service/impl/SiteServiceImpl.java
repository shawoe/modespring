package com.modespring.core.service.impl;

import com.modespring.core.common.PropertiesUtil;
import com.modespring.core.domain.Node;
import com.modespring.core.domain.Role;
import com.modespring.core.domain.User;
import com.modespring.core.domain.pojo.Site;
import com.modespring.core.repository.NodeDao;
import com.modespring.core.repository.RoleDao;
import com.modespring.core.repository.UserDao;
import com.modespring.core.service.SiteService;
import org.apache.commons.configuration.ConfigurationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shawoe on 2015/6/20.
 */
@Service
public class SiteServiceImpl implements SiteService {

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private NodeDao nodeDao;

    @Override
    public void init(Site site, String username, String password, String email) throws ConfigurationException {

        PropertiesUtil.updateStringProperty("jdbc", "jdbc.url", this.getPath(site));
        PropertiesUtil.updateStringProperty("jdbc", "jdbc.username", site.getJdbcUsername());
        PropertiesUtil.updateStringProperty("jdbc", "jdbc.password", site.getJdbcPassword());

        PropertiesUtil.updateStringProperty("global", "site.title", site.getTitle());
        PropertiesUtil.updateStringProperty("global","site.url",site.getUrl());

        // 添加角色
        List<Role> roleList = new ArrayList<>();
        Role role_admin = new Role();
        role_admin.setName("admin");
        role_admin.setTitle("管理员");
        role_admin.setPower(100);
        roleList.add(role_admin);

        Role role_user = new Role();
        role_user.setName("user");
        role_user.setTitle("注册用户");
        role_user.setPower(10);
        roleList.add(role_user);
        roleDao.save(roleList);

        // 添加用户
        User user = new User();
        user.setName(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setRole(role_admin);
        userDao.save(user);

        // 添加栏目
        Node node_global = new Node();
        node_global.setName("global");
        node_global.setTitle("首页");
        nodeDao.save(node_global);

        List<Node> nodeList = new ArrayList<>();
        Node node_focus = new Node(node_global);
        node_focus.setName("focus");
        node_focus.setTitle("推荐");
        nodeList.add(node_focus);

        Node node_guide = new Node(node_global);
        node_guide.setName("guide");
        node_guide.setTitle("导购");
        nodeList.add(node_guide);

        Node node_rent = new Node(node_global);
        node_rent.setName("rent");
        node_rent.setTitle("租车");
        nodeList.add(node_rent);
        nodeDao.save(nodeList);

    }

    public void update(Site site) throws ConfigurationException {
        PropertiesUtil.updateStringProperty("global", "site.title", site.getTitle());
        PropertiesUtil.updateStringProperty("global","site.logo",site.getLogo());
        PropertiesUtil.updateStringProperty("global","site.url",site.getUrl());
        PropertiesUtil.updateStringProperty("global","site.mospUrl",site.getMospUrl());
        PropertiesUtil.updateStringProperty("global","site.open",site.getOpen().toString());

        PropertiesUtil.updateStringProperty("jdbc", "jdbc.url", this.getPath(site));
        PropertiesUtil.updateStringProperty("jdbc", "jdbc.username", site.getJdbcUsername());
        PropertiesUtil.updateStringProperty("jdbc", "jdbc.password", site.getJdbcPassword());
    }

    public String getPath(Site site) {
        return "jdbc:mysql://" + site.getJdbcUrl() + "/" + site.getJdbcName() + "?characterEncoding=utf8";
    }

}
