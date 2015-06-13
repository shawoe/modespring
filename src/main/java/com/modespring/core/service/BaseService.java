package com.modespring.core.service;

import java.util.List;

/**
 * Created by Shawoe on 2015/5/14.
 */
public interface BaseService<T> {

    public T create(T entity);

    public void delete(Integer id);

    public T update(T entity);

    public List<T> updateALL(List<T> list);

    public T getOne(Integer id);

    public List<T> getAll();

    public T getByName(String name);


}
