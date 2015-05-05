package com.modespring.core.domain;

import com.modespring.core.domain.bean.UserBean;
import javax.persistence.Entity;
import java.util.Date;

/**
 * Created by Shawoe on 2015/4/16.
 */
@Entity
public class User extends UserBean {

    public User() {
        Date date = new Date();
        this.setRegisterDate(date);
        this.setLastLogin(date);
        Person person = new Person();
        //this.setLinkman(person);
        this.setCertification(false);
        this.setFrozen(false);
    }

}
