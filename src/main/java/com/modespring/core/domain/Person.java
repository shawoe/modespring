package com.modespring.core.domain;

import com.modespring.core.domain.bean.PersonBean;

import javax.persistence.Entity;

/**
 * Created by Shawoe on 2015/4/17.
 */
@Entity
public class Person extends PersonBean {

    public Person() {
        this.setCertification(false);
    }

}
