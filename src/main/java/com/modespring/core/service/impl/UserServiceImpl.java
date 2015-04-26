package com.modespring.core.service.impl;

import static com.modespring.core.common.ExceptionMessage.*;
import com.modespring.core.domain.User;
import com.modespring.core.repository.UserDao;
import com.modespring.core.service.BaseService;
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
public class UserServiceImpl extends BaseService implements UserService {

    @Autowired
    UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        super(userDao);
    }

    @Override
    public Boolean isExisted(String userName) {
        User user = userDao.findUserByUserName(userName);
        return user != null;
    }

    @Override
    public Boolean isLogged(HttpSession session) {
        User currentUser = (User) session.getAttribute("currentUser");
        return currentUser != null;
    }

    @Override
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

    @Override
    public void logout(HttpSession session) {
        User currentUser = (User) session.getAttribute("currentUser");
        currentUser.setUserLastLogin(new Date());
        userDao.saveAndFlush(currentUser);
        session.removeAttribute("currentUser");
    }

    @Override
    public void registerFormValidate(String userName, String userPassword, String confirmPassword, String userEmail) throws Exception {
        if (userName.isEmpty() || userPassword.isEmpty() || confirmPassword.isEmpty() || userEmail.isEmpty()) {
            throw new Exception(USER_AUTHENTICATION_EXCEPTION);
        } else if (!userPassword.equals(confirmPassword)) {
            throw new Exception(USER_AUTHENTICATION_EXCEPTION);
        }
    }

    @Override
    public void register(String userName, String userPassword, String userEmail) throws Exception {
        if (isExisted(userName)) {
            throw new Exception(USER_EXISTENCE_EXCEPTION);
        } else {
            User user = new User();
            user.setUserName(userName);
            user.setUserPassword(userPassword);
            user.setUserEmail(userEmail);
            userDao.save(user);
        }
    }

    @Override
    public User getUserDetailsById(Integer userId) {
        return userDao.findOne(userId);
    }

}
