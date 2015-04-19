package com.modespring.core.service;

import com.modespring.core.domain.bean.BaseBean;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Shawoe on 2015/4/19.
 */
public abstract class BaseService <T extends BaseBean, R extends JpaRepository> {

    private R repo;

    public BaseService(R repo) {
        this.repo = repo;
    }

    public void save(T entity) {
        repo.save(entity);
    }
}