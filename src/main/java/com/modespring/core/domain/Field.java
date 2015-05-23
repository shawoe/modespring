package com.modespring.core.domain;

import com.modespring.core.domain.bean.FieldBean;

import javax.persistence.Entity;

/**
 * Created by Shawoe on 2015/5/2.
 */
@Entity
public class Field extends FieldBean {

    public Field() {
        this.setType("text");
    }

}
