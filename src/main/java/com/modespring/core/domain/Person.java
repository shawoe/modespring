package com.modespring.core.domain;

import static com.modespring.core.common.DomainDefaultValue.*;
import com.modespring.core.domain.bean.PersonBean;
import javax.persistence.Entity;

/**
 * Created by Shawoe on 2015/4/17.
 */
@Entity
public class Person extends PersonBean {

    public Person() {
        this.setPersonName(PERSON_DEFAULT_NAME);
        this.setPersonEnglishName(PERSON_DEFAULT_ENGLISH_NAME);
        this.setPersonAvatar(PERSON_DEFAULT_AVATAR);
        this.setPersonSex(PERSON_DEFAULT_SEX);
        this.setPersonCertification(PERSON_DEFAULT_CERTIFICATION);
    }
    
}
