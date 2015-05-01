package com.modespring.core.service.impl;

import static com.modespring.core.common.ExceptionMessage.*;
import com.modespring.core.domain.User;
import com.modespring.core.repository.UserDao;
import com.modespring.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Date;

/**
 * Created by Shawoe on 2015/4/18.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    public Boolean isExisted(String userName) {
        User user = userDao.findByUserName(userName);
        return user != null;
    }
    public User login(String userName, String userPassword) throws Exception {
        User user = userDao.findByUserName(userName);
        if (user == null) {
            throw new Exception(USER_AUTHENTICATION_EXCEPTION);
        } else if (!user.getPassword().equals(userPassword)) {
            throw new Exception(USER_AUTHENTICATION_EXCEPTION);
        } else if (user.getFrozen()) {
            throw new Exception(USER_FROZEN_EXCEPTION);
        }
        return user;
    }

    public void logout(User user) {
        user.setLastLogin(new Date());
        userDao.saveAndFlush(user);
    }

    public User register(User user) throws Exception {
        if (isExisted(user.getUsername())) {
            throw new Exception(USER_EXISTENCE_EXCEPTION);
        }
        return  userDao.save(user);
    }

    public User updateDetails(User user) {
        return userDao.saveAndFlush(user);
    }

}
