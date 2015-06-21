package com.modespring.core.service.impl;

import com.modespring.core.domain.Field;
import com.modespring.core.repository.FieldDao;
import com.modespring.core.service.FieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        for (Integer cur_id : id) {
            fieldDao.delete(cur_id);
        }
    }

    public void deleteAll(List<Field> fieldList) throws Exception {
        for (Field field : fieldList) {
            fieldDao.delete(field);
        }
    }

    public Field update(Field field) {
        return fieldDao.saveAndFlush(field);
    }

    public List<Field> updateALL(List<Field> fieldList) {
        return fieldDao.save(fieldList);
    }

    @Override
    public List<Field> updateALL(Integer[] id, String[] name, String[] title) {
        List<Field> fieldList = new ArrayList<>();
        for (int i = 0; i < id.length; i++) {
            Field field = fieldDao.findOne(id[i]);
            field.setName(name[i]);
            field.setTitle(title[i]);
            fieldList.add(field);
        }
        return fieldDao.save(fieldList);
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
