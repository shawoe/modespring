package com.modespring.core.repository;

import com.modespring.core.domain.Role;
import com.modespring.core.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by Shawoe on 2015/4/30.
 */
@Repository
public interface RoleDao extends JpaRepository<Role, Integer> {

    @Query("SELECT role FROM Role role WHERE role.name = ?1")
    public Role findByName(String name);
}
