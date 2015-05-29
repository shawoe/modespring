package com.modespring.core.repository;

import com.modespring.core.domain.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by Shawoe on 2015/4/30.
 */
@Repository
public interface ModelDao extends JpaRepository<Model, Integer> {

    @Query("SELECT model FROM Model model WHERE model.name = ?1")
    public Model findByName(String name);
}
