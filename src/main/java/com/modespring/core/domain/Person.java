package com.modespring.core.domain;

import com.modespring.core.domain.bean.PersonBean;

/**
 * Created by Shawoe on 2015/4/17.
 */
public class Person extends PersonBean {

    private static final String PERSON_NAME = "无名侠士";
    private static final String PERSON_ENGLISH_NAME = "NAMELESS";
    private static final String PERSON_AVATAR = "";
    private static final String PERSON_SEX = "保密";
    private static final Boolean PERSON_CERTIFICATION = false;

    public Person() {
        this.setPersonName(PERSON_NAME);
        this.setPersonEnglishName(PERSON_ENGLISH_NAME);
        this.setPersonAvatar(PERSON_AVATAR);
        this.setPersonSex(PERSON_SEX);
        this.setPersonCertification(PERSON_CERTIFICATION);
    }
    
}
