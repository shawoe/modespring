package com.modespring.core.domain.bean;

import com.modespring.core.domain.User;

import java.util.Date;

/**
 * Created by Shawoe on 2015/4/17.
 */
public abstract class MessageBean {

    private Integer messageID;
    private User messageSender;
    private User messageAddressee;
    private String messageTitle;
    private String messageContent;
    private Date messageSendtime;
    private Boolean messageMarkread;

    public MessageBean() {
    }

    public Integer getMessageID() {
        return messageID;
    }

    public void setMessageID(Integer messageID) {
        this.messageID = messageID;
    }

    public User getMessageSender() {
        return messageSender;
    }

    public void setMessageSender(User messageSender) {
        this.messageSender = messageSender;
    }

    public User getMessageAddressee() {
        return messageAddressee;
    }

    public void setMessageAddressee(User messageAddressee) {
        this.messageAddressee = messageAddressee;
    }

    public String getMessageTitle() {
        return messageTitle;
    }

    public void setMessageTitle(String messageTitle) {
        this.messageTitle = messageTitle;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public Date getMessageSendtime() {
        return messageSendtime;
    }

    public void setMessageSendtime(Date messageSendtime) {
        this.messageSendtime = messageSendtime;
    }

    public Boolean getMessageMarkread() {
        return messageMarkread;
    }

    public void setMessageMarkread(Boolean messageMarkread) {
        this.messageMarkread = messageMarkread;
    }

}
