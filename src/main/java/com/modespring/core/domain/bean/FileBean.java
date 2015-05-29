package com.modespring.core.domain.bean;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * Created by Shawoe on 2015/5/2.
 */
@MappedSuperclass
public abstract class FileBean extends BaseBean {

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String filename;

    @Column(nullable = false)
    private Integer size;

    @Column(nullable = false)
    private String path;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
