package com.modespring.core.domain;

import com.modespring.core.domain.bean.MessageBean;

import java.util.Date;

/**
 * Created by Shawoe on 2015/4/17.
 */
public class Message extends MessageBean {

    private static final String MESSAGE_TITLE = "勿忘我";
    private static final Boolean MESSAGE_MARKREAD = false;

    public Message() {
        Date date = new Date();
        this.setMessageSendTime(date);
        this.setMessageTitle(MESSAGE_TITLE);
        this.setMessageMarkRead(MESSAGE_MARKREAD);
    }

}
