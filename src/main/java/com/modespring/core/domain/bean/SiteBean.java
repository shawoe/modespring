package com.modespring.core.domain.bean;

import javax.persistence.*;

/**
 * Created by Shawoe on 2015/4/30.
 */
@MappedSuperclass
public abstract class SiteBean extends BaseBean {

    @Column(unique = true, nullable = false)
    private Boolean open;

    public Boolean getOpen() {
        return open;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }
}
