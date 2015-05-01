package com.modespring.core.domain.bean;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * Created by Shawoe on 2015/5/1.
 */
@MappedSuperclass
public abstract class RoleBean  extends BaseBean {

    @Column(unique = true, nullable = false)
    private String name;

    private Integer power;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

}
