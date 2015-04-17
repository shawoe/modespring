package com.modespring.core.domain.bean;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Shawoe on 2015/4/17.
 */
@Entity
@Table(name = "table_person")
public abstract class PersonBean extends BaseBean {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private Integer personId;

    @Column(name = "person_name")
    private String personName;

    @Column(name = "person_english_name")
    private String personEnglishName;

    @Column(name = "person_avatar")
    private String personAvatar;

    @Column(name = "person_sex")
    private String personSex;

    @Column(name = "person_email")
    private String personEmail;

    @Column(name = "person_phone")
    private Integer personPhone;

    @Column(name = "person_birthday")
    private Date personBirthday;

    @Column(name = "person_certification")
    private Boolean personCertification;

    public PersonBean() {
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonEnglishName() {
        return personEnglishName;
    }

    public void setPersonEnglishName(String personEnglishName) {
        this.personEnglishName = personEnglishName;
    }

    public String getPersonAvatar() {
        return personAvatar;
    }

    public void setPersonAvatar(String personAvatar) {
        this.personAvatar = personAvatar;
    }

    public String getPersonSex() {
        return personSex;
    }

    public void setPersonSex(String personSex) {
        this.personSex = personSex;
    }

    public Date getPersonBirthday() {
        return personBirthday;
    }

    public void setPersonBirthday(Date personBirthday) {
        this.personBirthday = personBirthday;
    }

    public String getPersonEmail() {
        return personEmail;
    }

    public void setPersonEmail(String personEmail) {
        this.personEmail = personEmail;
    }

    public Integer getPersonPhone() {
        return personPhone;
    }

    public void setPersonPhone(Integer personPhone) {
        this.personPhone = personPhone;
    }

    public Boolean getPersonCertification() {
        return personCertification;
    }

    public void setPersonCertification(Boolean personCertification) {
        this.personCertification = personCertification;
    }

}
