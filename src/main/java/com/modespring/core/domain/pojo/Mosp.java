package com.modespring.core.domain.pojo;

/**
 * Created by Shawoe on 2015/5/30.
 */
public class Mosp {

    private String name;

    private String title;

    public Mosp(String name, String title) {
        this.name = name;
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
