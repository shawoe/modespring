package com.modespring.core.service.impl;

import static com.modespring.core.common.ExceptionMessage.*;
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
            throw new Exception(USER_AUTHENTICATION_EXCEPTION);
        } else if (!user.getPassword().equals(userPassword)) {
            throw new Exception(USER_AUTHENTICATION_EXCEPTION);
        } else if (user.getFrozen()) {
            throw new Exception(USER_FROZEN_EXCEPTION);
        }
        return user;
    }

    public void logout(String username) {
        User user =  userDao.findByUsername(username);
        user.setLastLogin(new Date());
        userDao.saveAndFlush(user);
    }

    public User register(User user) throws Exception {
        if (isExisted(user.getName())) {
            throw new Exception(USER_EXISTENCE_EXCEPTION);
        }
        return  userDao.save(user);
    }

    public User getDetailsByUsername(String username) {
        return userDao.findByUsername(username);
    }

    public List<User> getAll() {
        return userDao.findAll();
    }

    public User updateDetails(User user) {
        return userDao.saveAndFlush(user);
    }

}
