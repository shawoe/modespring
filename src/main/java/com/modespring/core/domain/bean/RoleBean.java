package com.modespring.core.domain.bean;

import com.modespring.core.domain.Power;

import javax.persistence.Column;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;
import java.util.List;

/**
 * Created by Shawoe on 2015/5/1.
 */
@MappedSuperclass
public abstract class RoleBean  extends BaseBean {

    private Integer power;

    @ManyToMany
    @JoinTable
    private List<Power> powerList;

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public List<Power> getPowerList() {
        return powerList;
    }

    public void setPowerList(List<Power> powerList) {
        this.powerList = powerList;
    }

}
