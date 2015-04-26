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

    public Boolean isExisted(String userName) {
        User user = userDao.findUserByUserName(userName);
        return user != null;
    }

    public Boolean isLogged(HttpServletRequest request) {
        User currentUser = (User) request.getSession().getAttribute("currentUser");
        return currentUser != null;
    }

    public void login(HttpServletRequest request) throws Exception {
        String userName = request.getParameter("userName");
        String userPassword = request.getParameter("userPassword");
        User user = userDao.findUserByUserName(userName);
        if (user == null) {
            throw new Exception(USER_AUTHENTICATION_EXCEPTION);
        } else if (!user.getUserPassword().equals(userPassword)) {
            throw new Exception(USER_AUTHENTICATION_EXCEPTION);
        } else if (user.getUserFrozen()) {
            throw new Exception(USER_FROZEN_EXCEPTION);
        }
        request.getSession().setAttribute("currentUser", user);
    }

    public void logout(HttpServletRequest request) {
        User currentUser = (User) request.getSession().getAttribute("currentUser");
        currentUser.setUserLastLogin(new Date());
        userDao.saveAndFlush(currentUser);
        request.getSession().removeAttribute("currentUser");
    }

    public void registerFormValidate(HttpServletRequest request) throws Exception {
        String userName = request.getParameter("userName");
        String userPassword = request.getParameter("userPassword");
        String confirmPassword = request.getParameter("confirmPassword");
        if (userName == null || userName.isEmpty()) {
            throw new Exception(USER_AUTHENTICATION_EXCEPTION);
        } else if (!userPassword.equals(confirmPassword)) {
            throw new Exception(USER_AUTHENTICATION_EXCEPTION);
        }
    }

    public void register(HttpServletRequest request) throws Exception {
        String userName = request.getParameter("userName");
        String userPassword = request.getParameter("userPassword");
        if (isExisted(userName)) {
            throw new Exception(USER_EXISTENCE_EXCEPTION);
        } else {
            User user = new User();
            user.setUserName(userName);
            user.setUserPassword(userPassword);
            userDao.save(user);
        }
    }

    public User getUserDetailsById(Integer userId) {
        return userDao.findOne(userId);
    }

}
