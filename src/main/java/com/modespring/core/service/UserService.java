package com.modespring.core.service;

import com.modespring.core.domain.User;

/**
 * Created by Shawoe on 2015/4/26.
 */
public interface UserService {

    public Boolean isExisted(String username);

    public User login(String username, String password) throws Exception;

    public void logout(String username);

    public User register(User user) throws Exception;

    public User getDetailsByUsername(String username);

    public User updateDetails(User user);

}
