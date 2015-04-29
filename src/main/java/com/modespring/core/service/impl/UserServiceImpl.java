package com.modespring.core.service.impl;

import static com.modespring.core.common.ExceptionMessage.*;
import com.modespring.core.domain.User;
import com.modespring.core.repository.UserDao;
import com.modespring.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpSession;
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
        User user = userDao.findUserByUserName(userName);
        return user != null;
    }
    public User login(String userName, String userPassword) throws Exception {
        User user = userDao.findUserByUserName(userName);
        if (user == null) {
            throw new Exception(USER_AUTHENTICATION_EXCEPTION);
        } else if (!user.getUserPassword().equals(userPassword)) {
            throw new Exception(USER_AUTHENTICATION_EXCEPTION);
        } else if (user.getUserFrozen()) {
            throw new Exception(USER_FROZEN_EXCEPTION);
        }
        return user;
    }

    public void logout(HttpSession session) {
        User currentUser = (User) session.getAttribute("currentUser");
        currentUser.setUserLastLogin(new Date());
        userDao.saveAndFlush(currentUser);
        session.removeAttribute("currentUser");
    }

    public void register(User user) throws Exception {
        if (isExisted(user.getUserName())) {
            throw new Exception(USER_EXISTENCE_EXCEPTION);
        } else {
            userDao.save(user);
        }
    }

    public User getUserDetailsById(Integer userId) {
        return userDao.findOne(userId);
    }

}
