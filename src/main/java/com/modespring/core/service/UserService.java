package com.modespring.core.service;

import com.modespring.core.domain.User;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Shawoe on 2015/4/23.
*/
public interface UserService {

    public Boolean isUserExistence(String userName);
    public Boolean isUserLogged (HttpServletRequest request);
    public User loginUser(String userName, String userPassword) throws Exception;
    public User registerUser(User user) throws Exception;
    public User getUserDetailsById(Integer userId);

}
