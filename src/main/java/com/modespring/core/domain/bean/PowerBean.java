package com.modespring.core.domain.bean;

import javax.persistence.MappedSuperclass;

/**
 * Created by Shawoe on 2015/5/9.
 */
@MappedSuperclass
public abstract class PowerBean extends BaseBean {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
