package com.modespring.core.repository;

import com.modespring.core.domain.Node;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Shawoe on 2015/4/30.
 */
@Repository
public interface NodeDao extends JpaRepository<Node, Integer> {
}
