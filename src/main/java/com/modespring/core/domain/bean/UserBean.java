package com.modespring.core.domain.bean;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Shawoe on 2015/4/17.
 */
@Entity
@Table(name = "table_user")
public abstract class UserBean extends BaseBean {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_password")
    private String userPassword;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "user_avatar")
    private String userAvatar;

    @Column(name = "user_register_date")
    private Date userRegisterDate;

    @Column(name = "user_last_login")
    private Date userLastLogin;

    @Column(name = "user_certification")
    private Boolean userCertification;

    @Column(name = "user_frozen")
    private Boolean userFrozen;

    public UserBean() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public Date getUserLastLogin() {
        return userLastLogin;
    }

    public void setUserLastLogin(Date userLastLogin) {
        this.userLastLogin = userLastLogin;
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
