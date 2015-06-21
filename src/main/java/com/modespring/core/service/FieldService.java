package com.modespring.core.service;

import com.modespring.core.domain.Field;

import java.util.List;

/**
 * Created by Shawoe on 2015/5/1.
 */
public interface FieldService extends BaseService<Field> {

    public List<Field> createALL(List<Field> fieldList);
    public void deleteAll(List<Field> fieldList) throws Exception;
}
