package com.modespring.core.service;

import com.modespring.core.domain.User;
import javax.servlet.http.HttpSession;

/**
 * Created by Shawoe on 2015/4/26.
 */
public interface UserService {

    Boolean isExisted(String userName);

    Boolean isLogged(HttpSession session);

    User login(String userName, String userPassword) throws Exception;

    void logout(HttpSession session);

    void registerFormValidate(String userName, String userPassword, String confirmPassword, String userEmail) throws Exception;

    void register(String userName, String userPassword, String userEmail) throws Exception;

    User getUserDetailsById(Integer userId);
}
