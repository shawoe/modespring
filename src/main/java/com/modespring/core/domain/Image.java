package com.modespring.core.domain;

import com.modespring.core.domain.bean.FileBean;

import javax.persistence.Entity;

/**
 * Created by Shawoe on 2015/5/2.
 */
@Entity
public class Image extends FileBean {

    public Image(String name, String type, String path, String filename, Integer size) {
        this.setName(name);
        this.setType(type);
        this.setPath(path);
        this.setFilename(filename);
        this.setSize(size);
    }

    public Image() {
    }

}
