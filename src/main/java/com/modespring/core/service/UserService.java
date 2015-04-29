package com.modespring.core.service;

import com.modespring.core.domain.User;
import javax.servlet.http.HttpSession;

/**
 * Created by Shawoe on 2015/4/26.
 */
public interface UserService {

    Boolean isExisted(String userName);

    User login(String userName, String userPassword) throws Exception;

    void logout(HttpSession session);

    void register(User user) throws Exception;

    User getUserDetailsById(Integer userId);
}
