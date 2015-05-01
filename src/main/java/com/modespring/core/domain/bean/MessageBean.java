package com.modespring.core.domain.bean;

import com.modespring.core.domain.User;
import javax.persistence.*;
import java.util.Date;

/**
 * Created by Shawoe on 2015/4/17.
 */
@MappedSuperclass
public abstract class MessageBean extends BaseBean {

    @ManyToOne
    @JoinColumn
    private User sender;

    @ManyToOne
    @JoinColumn
    private User addressee;

    private String title;

    private String content;

    private Date sendTime;

    private Boolean readMark;

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getAddressee() {
        return addressee;
    }

    public void setAddressee(User addressee) {
        this.addressee = addressee;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Boolean getReadMark() {
        return readMark;
    }

    public void setReadMark(Boolean readMark) {
        this.readMark = readMark;
    }
}
