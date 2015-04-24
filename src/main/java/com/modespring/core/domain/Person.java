package com.modespring.core.domain;

import com.modespring.core.domain.bean.PersonBean;
import javax.persistence.Entity;

/**
 * Created by Shawoe on 2015/4/17.
 */
@Entity
public class Person extends PersonBean {

    private static final String PERSON_DEFAULT_NAME = "无名侠士";
    private static final String PERSON_DEFAULT_ENGLISH_NAME = "NAMELESS";
    private static final String PERSON_DEFAULT_AVATAR = "";
    private static final String PERSON_DEFAULT_SEX = "保密";
    private static final Boolean PERSON_DEFAULT_CERTIFICATION = false;

    public Person() {
        this.setPersonName(PERSON_DEFAULT_NAME);
        this.setPersonEnglishName(PERSON_DEFAULT_ENGLISH_NAME);
        this.setPersonAvatar(PERSON_DEFAULT_AVATAR);
        this.setPersonSex(PERSON_DEFAULT_SEX);
        this.setPersonCertification(PERSON_DEFAULT_CERTIFICATION);
    }
    
}
