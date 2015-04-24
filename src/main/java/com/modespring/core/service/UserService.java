package com.modespring.core.service;

import com.modespring.core.domain.User;

/**
 * Created by Shawoe on 2015/4/23.
*/
public interface UserService {
    public Boolean isUserExistence(String userName);
    public User registerUser(User user) throws Exception;
    public User getUserDetailsById(Integer userId);
}
