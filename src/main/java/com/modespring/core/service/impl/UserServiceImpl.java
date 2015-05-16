package com.modespring.core.service.impl;

import com.modespring.core.domain.User;
import com.modespring.core.repository.UserDao;
import com.modespring.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

/**
 * Created by Shawoe on 2015/4/18.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    public Boolean isExisted(String userName) {
        User user = userDao.findByUsername(userName);
        return user != null;
    }
    public User login(String userName, String userPassword) throws Exception {
        User user = userDao.findByUsername(userName);
        if (user == null) {
            throw new Exception("用户不存在");
        } else if (!user.getPassword().equals(userPassword)) {
            throw new Exception("密码不正确");
        } else if (user.getFrozen()) {
            throw new Exception("用户已冻结");
        }
        user.setLastLogin(new Date());
        return userDao.saveAndFlush(user);
    }

    public User register(User user) throws Exception {
        if (isExisted(user.getName())) {
            throw new Exception("用户已存在");
        }
        return  userDao.save(user);
    }

    public User getByName(String username) {
        return userDao.findByUsername(username);
    }

    public List<User> getAll() {
        return userDao.findAll();
    }

    public User updateDetails(User user) {
        return userDao.saveAndFlush(user);
    }

}
