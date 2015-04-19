package com.modespring.core.repository;

import com.modespring.core.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Shawoe on 2015/4/18.
 */
@Repository
public interface UserDao extends JpaRepository<User, Integer> {

}