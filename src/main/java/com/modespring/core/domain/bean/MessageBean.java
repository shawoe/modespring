package com.modespring.core.domain.bean;

import com.modespring.core.domain.User;
import javax.persistence.*;
import java.util.Date;

/**
 * Created by Shawoe on 2015/4/17.
 */
@MappedSuperclass
public abstract class MessageBean extends BaseBean {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer messageId;
    private User messageSender;
    private User messageAddressee;
    private String messageTitle;
    private String messageContent;
    private Date messageSendTime;
    private Boolean messageMarkRead;

    public MessageBean() {
    }

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
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

    public Date getMessageSendTime() {
        return messageSendTime;
    }

    public void setMessageSendTime(Date messageSendTime) {
        this.messageSendTime = messageSendTime;
    }

    public Boolean getMessageMarkRead() {
        return messageMarkRead;
    }

    public void setMessageMarkRead(Boolean messageMarkRead) {
        this.messageMarkRead = messageMarkRead;
    }
}
