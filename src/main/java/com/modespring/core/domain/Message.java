package com.modespring.core.domain;

import static com.modespring.core.common.DomainDefaultValue.*;
import com.modespring.core.domain.bean.MessageBean;
import javax.persistence.Entity;
import java.util.Date;

/**
 * Created by Shawoe on 2015/4/17.
 */
@Entity
public class Message extends MessageBean {

    public Message() {
        Date date = new Date();
        this.setMessageSendTime(date);
        this.setMessageTitle(MESSAGE_DEFAULT_TITLE);
        this.setMessageMarkRead(MESSAGE_DEFAULT_MARK_READ);
    }

}
