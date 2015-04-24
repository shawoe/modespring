package com.modespring.core.domain;

import com.modespring.core.domain.bean.UserBean;
import javax.persistence.*;
import java.util.Date;

/**
 * Created by Shawoe on 2015/4/16.
 */
@Entity
public class User extends UserBean {

    private static final String USER_DEFAULT_NAME = "无名侠士";
    private static final String USER_DEFAULT_PASSWORD = "";
    private static final String USER_DEFAULT_AVATAR = "";
    private static final Boolean USER_DEFAULT_CERTIFICATION = false;
    private static final Boolean USER_DEFAULT_FROZEN = false;

    public User() {
        Date date = new Date();
        this.setUserRegisterDate(date);
        this.setUserLastLogin(date);
        this.setUserName(USER_DEFAULT_NAME);
        this.setUserPassword(USER_DEFAULT_PASSWORD);
        this.setUserAvatar(USER_DEFAULT_AVATAR);
        this.setUserCertification(USER_DEFAULT_CERTIFICATION);
        this.setUserFrozen(USER_DEFAULT_FROZEN);
    }

}
