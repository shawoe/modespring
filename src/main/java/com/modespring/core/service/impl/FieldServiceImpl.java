package com.modespring.core.service.impl;

import com.modespring.core.domain.Field;
import com.modespring.core.repository.FieldDao;
import com.modespring.core.service.FieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Shawoe on 2015/5/1.
 */
@Service
public class FieldServiceImpl implements FieldService {

    @Autowired
    FieldDao fieldDao;

    public Field create(Field field) {
        return fieldDao.save(field);
    }

    public List<Field> createALL(List<Field> fieldList) {
        return fieldDao.save(fieldList);
    }

    public void delete(Integer id) {
        fieldDao.delete(id);
    }

    @Override
    public void deleteAll(Integer[] id) throws Exception {

    }

    public Field update(Field field) {
        return fieldDao.saveAndFlush(field);
    }

    public List<Field> updateALL(List<Field> fieldList) {
        return fieldDao.save(fieldList);
    }

    @Override
    public List<Field> updateALL(Integer[] id, String[] name, String[] title) {
        return null;
    }

    public Field getOne(Integer id) {
        return fieldDao.findOne(id);
    }

    public List<Field> getAll() {
        return fieldDao.findAll();
    }

    public Field getByName(String name) {
        return null;
    }

}
