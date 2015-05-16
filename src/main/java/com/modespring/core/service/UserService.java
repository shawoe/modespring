package com.modespring.core.service;

import com.modespring.core.domain.User;

import java.util.List;

/**
 * Created by Shawoe on 2015/4/26.
 */
public interface UserService {

    public Boolean isExisted(String username);

    public User login(String username, String password) throws Exception;

    public User register(User user) throws Exception;

    public User getByName(String username);

    public List<User> getAll();

    public User updateDetails(User user);

}
