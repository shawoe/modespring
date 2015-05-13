package com.modespring.core.domain.bean;

import com.modespring.core.domain.Person;
import com.modespring.core.domain.Role;
import javax.persistence.*;
import java.util.Date;

/**
 * Created by Shawoe on 2015/4/17.
 */
@MappedSuperclass
public abstract class UserBean  extends BaseBean {

    @Column(unique = true, nullable = false)
    private String name;

    private String password;

    @Column(unique = true, nullable = false)
    private String email;

    private String avatar;

    @ManyToOne
    @JoinColumn
    private Role role;

    @OneToOne
    @JoinColumn
    private Person linkman;

    private Date registerDate;

    private Date lastLogin;

    private Boolean frozen;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Person getLinkman() {
        return linkman;
    }

    public void setLinkman(Person linkman) {
        this.linkman = linkman;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Boolean getFrozen() {
        return frozen;
    }

    public void setFrozen(Boolean frozen) {
        this.frozen = frozen;
    }
}
