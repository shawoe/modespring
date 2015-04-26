package com.modespring.core.service;

import com.modespring.core.domain.User;
import org.springframework.http.HttpRequest;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Shawoe on 2015/4/23.
*/
public interface UserService {

    public Boolean isExisted(String userName);
    public Boolean isLogged (HttpServletRequest request);
    public void login(HttpServletRequest request) throws Exception;
    public void logout(HttpServletRequest request);
    public User register(User user) throws Exception;
    public User getUserDetailsById(Integer userId);

}
