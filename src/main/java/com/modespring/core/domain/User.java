package com.modespring.core.domain;

import com.modespring.core.domain.bean.UserBean;

import java.util.Date;

/**
 * Created by Shawoe on 2015/4/16.
 */
public class User extends UserBean {

    private static final String USER_NAME = "无名侠士";
    private static final String USER_PASSWORD = "";
    private static final String USER_AVATAR = "";
    private static final Boolean USER_CERTIFICATION = false;
    private static final Boolean USER_FROZEN = false;

    public User() {
        Date date = new Date();
        this.setUserRegisterDate(date);
        this.setUserLastLogin(date);
        this.setUserName(USER_NAME);
        this.setUserPassword(USER_PASSWORD);
        this.setUserAvatar(USER_AVATAR);
        this.setUserCertification(USER_CERTIFICATION);
        this.setUserFrozen(USER_FROZEN);
    }

}
