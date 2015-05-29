package com.modespring.core.service;

import com.modespring.core.domain.Field;
import com.modespring.core.domain.Model;

import java.util.List;

/**
 * Created by Shawoe on 2015/5/1.
 */
public interface ModelService extends BaseService<Model> {

    public List<Field> getFieldList(String modelName);

}
