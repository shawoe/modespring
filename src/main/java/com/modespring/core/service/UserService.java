package com.modespring.core.service;

import com.modespring.core.domain.User;

/**
 * Created by Shawoe on 2015/4/26.
 */
public interface UserService {

    Boolean isExisted(String username);

    User login(String username, String password) throws Exception;

    void logout(User user);

    User register(User user) throws Exception;

    User editDetails(User user);

}
