package com.modespring.core.repository;

import com.modespring.core.domain.User;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 * Created by Shawoe on 2015/4/18.
 */
@Repository("userDao")
@Transactional
public class UserDao {

    @PersistenceContext
    private EntityManager em;

    public void addUser(User user) {
        em.persist(user);
    }

}
