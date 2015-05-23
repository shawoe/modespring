package com.modespring.core.service.impl;

import com.modespring.core.domain.Role;
import com.modespring.core.repository.PowerDao;
import com.modespring.core.repository.RoleDao;
import com.modespring.core.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Shawoe on 2015/5/8.
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private PowerDao powerDao;

    @Autowired
    private RoleDao roleDao;


    public Role create(Role role) {
        return roleDao.save(role);
    }

    public void delete(Integer id) {
        roleDao.delete(id);
    }

    public Role update(Role role) {
        return roleDao.saveAndFlush(role);
    }

    public void updateALL(List<Role> roleList) {
        roleDao.save(roleList);
    }

    public Role getOne(Integer id) {
        return roleDao.findOne(id);
    }

    public Role getByName(String name) {
        return null;//roleDao.findByName(name);
    }

    public List<Role> getAll() {
        return roleDao.findAll();
    }

    @Transactional
    public void accessControl() {
        int accessControl = roleDao.getOne(1).getPowerList().indexOf(powerDao.getOne(1));
    }
}
