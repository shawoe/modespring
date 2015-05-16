package com.modespring.core.domain.bean;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * Created by Shawoe on 2015/5/2.
 */
@MappedSuperclass
public abstract class FieldBean extends BaseBean {

    @Column(nullable = false)
    private String type;

    private String defaultValue;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

}
