package com.modespring.core.repository;

import com.modespring.core.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by Shawoe on 2015/4/18.
 */
@Repository
public interface UserDao extends JpaRepository<User, Integer> {

    @Query("SELECT user FROM User user WHERE user.userName = ?1")
    public User findByUserName(String userName);

    @Query("SELECT user FROM User user WHERE user.userEmail = ?1")
    public User findByUserEmail(String userEmail);

}