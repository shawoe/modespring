package com.modespring.core.domain.pojo;

/**
 * Created by Shawoe on 2015/6/11.
 */
public class Site {
    private String title;
    private String logo;
    private String url;
    private String mospUrl;
    private Boolean open;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMospUrl() {
        return mospUrl;
    }

    public void setMospUrl(String mospUrl) {
        this.mospUrl = mospUrl;
    }

    public Boolean getOpen() {
        return open;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }
}
