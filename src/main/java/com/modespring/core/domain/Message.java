package com.modespring.core.domain;

import com.modespring.core.domain.bean.MessageBean;
import javax.persistence.Entity;
import java.util.Date;

/**
 * Created by Shawoe on 2015/4/17.
 */
@Entity
public class Message extends MessageBean {

    private static final String MESSAGE_TITLE = "勿忘我";
    private static final Boolean MESSAGE_MARK_READ = false;

    public Message() {
        Date date = new Date();
        this.setMessageSendTime(date);
        this.setMessageTitle(MESSAGE_TITLE);
        this.setMessageMarkRead(MESSAGE_MARK_READ);
    }

}
