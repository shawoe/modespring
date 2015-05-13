package com.modespring.core.domain.bean;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Shawoe on 2015/4/17.
 */
@MappedSuperclass
public abstract class PersonBean  extends BaseBean {

    private String name;
    private String englishName;
    private String avatar;
    private String sex;
    private String address;
    private Integer phone;
    private Integer QQ;
    private Integer weChat;
    private Integer blog;
    private Date birthday;
    private Boolean certification;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public Integer getQQ() {
        return QQ;
    }

    public void setQQ(Integer QQ) {
        this.QQ = QQ;
    }

    public Integer getWeChat() {
        return weChat;
    }

    public void setWeChat(Integer weChat) {
        this.weChat = weChat;
    }

    public Integer getBlog() {
        return blog;
    }

    public void setBlog(Integer blog) {
        this.blog = blog;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Boolean getCertification() {
        return certification;
    }

    public void setCertification(Boolean certification) {
        this.certification = certification;
    }
}
