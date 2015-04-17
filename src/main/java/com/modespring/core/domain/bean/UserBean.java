package com.modespring.core.domain.bean;

import java.util.Date;

/**
 * Created by Shawoe on 2015/4/17.
 */
public abstract class UserBean {

    private Integer userID;
    private String userName;
    private String userPassword;
    private String userEmail;
    private String userAvatar;
    private Date userRegisterDate;
    private Date userLastLoginDate;
    private Boolean userCertification;
    private Boolean userFrozen;

    public UserBean() {
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    public Date getUserRegisterDate() {
        return userRegisterDate;
    }

    public void setUserRegisterDate(Date userRegisterDate) {
        this.userRegisterDate = userRegisterDate;
    }

    public Date getUserLastLoginDate() {
        return userLastLoginDate;
    }

    public void setUserLastLoginDate(Date userLastLoginDate) {
        this.userLastLoginDate = userLastLoginDate;
    }

    public Boolean getUserCertification() {
        return userCertification;
    }

    public void setUserCertification(Boolean userCertification) {
        this.userCertification = userCertification;
    }

    public Boolean getUserFrozen() {
        return userFrozen;
    }

    public void setUserFrozen(Boolean userFrozen) {
        this.userFrozen = userFrozen;
    }

}
