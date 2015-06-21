package com.modespring.core.service.impl;

import com.modespring.core.domain.Field;
import com.modespring.core.domain.Model;
import com.modespring.core.repository.ModelDao;
import com.modespring.core.service.FieldService;
import com.modespring.core.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shawoe on 2015/5/1.
 */
@Service
public class ModelServiceImpl implements ModelService {

    @Autowired
    ModelDao modelDao;

    @Autowired
    FieldService fieldService;

    public Model create(Model model) {
        return modelDao.save(model);
    }

    public void delete(Integer id) {
        modelDao.delete(id);
    }

    @Override
    public void deleteAll(Integer[] id) throws Exception {
        for (Integer cur_id : id) {
            modelDao.delete(cur_id);
        }
    }

    public Model update(Model model) {
        return modelDao.saveAndFlush(model);
    }

    public List<Model> updateALL(List<Model> modelList) {
        return modelDao.save(modelList);
    }

    @Override
    public List<Model> updateALL(Integer[] id, String[] name, String[] title) {
        List<Model> modelList = new ArrayList<Model>();
        for (int i = 0; i < id.length; i++) {
            Model model = modelDao.findOne(id[i]);
            model.setName(name[i]);
            model.setTitle(title[i]);
            modelList.add(model);
        }
        return modelDao.save(modelList);
    }

    public Model getOne(Integer id) {
        return modelDao.findOne(id);
    }

    public Model getByName(String name) {
        return modelDao.findByName(name);
    }

    @Transactional
    public List<Field> getFieldList(String modelName) {
        List<Field> fieldList = modelDao.findByName(modelName).getFieldList();
        return fieldList;
    }

    public List<Model> getAll() {
        return modelDao.findAll();
    }

}
