package com.modespring.core.domain.bean;

import com.modespring.core.domain.Field;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Shawoe on 2015/5/2.
 */
@MappedSuperclass
public abstract class ModelBean extends BaseBean {

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn
    private List<Field> fieldList;

    public List<Field> getFieldList() {
        return fieldList;
    }

    public void setFieldList(List<Field> fieldList) {
        this.fieldList = fieldList;
    }
}
