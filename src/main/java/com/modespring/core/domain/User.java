package com.modespring.core.domain;

import static com.modespring.core.common.DomainDefaultValue.*;
import com.modespring.core.domain.bean.UserBean;
import javax.persistence.*;
import java.util.Date;

/**
 * Created by Shawoe on 2015/4/16.
 */
@Entity
public class User extends UserBean {

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
