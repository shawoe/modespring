package com.modespring.core.service.impl;

import static com.modespring.core.common.ExceptionMessage.*;
import com.modespring.core.domain.User;
import com.modespring.core.repository.UserDao;
import com.modespring.core.service.BaseService;
import com.modespring.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

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

    public Boolean isUserExistence(String userName) {
        User user = userDao.findUserByUserName(userName);
        if (user == null) {
            return false;
        }
        return true;
    }

    public Boolean isUserLogged (HttpServletRequest request) {
        User currentUser = (User)request.getSession().getAttribute("currentUser");
        if (currentUser == null) {
            return false;
        }
        return true;
    }

    public User loginUser(String userName, String userPassword) throws Exception {
        User user = userDao.findUserByUserName(userName);
        if (user==null) {
            throw new Exception(USER_AUTHENTICATION_EXCEPTION);
        }
        else if (!user.getUserPassword().equals(userPassword)) {
            throw new Exception(USER_AUTHENTICATION_EXCEPTION);
        }
        else if (user.getUserFrozen()) {
            throw new Exception(USER_FROZEN_EXCEPTION);
        }
        return user;
    }

    public User registerUser(User user) throws Exception {
        if (isUserExistence(user.getUserName())) {
            throw new Exception(USER_EXISTENCE_EXCEPTION);
        }
        user = userDao.save(user);
        return user;
    }

    public User getUserDetailsById(Integer userId) {
        User user = userDao.findOne(userId);
        return user;
    }

}
