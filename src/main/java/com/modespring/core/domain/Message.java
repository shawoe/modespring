package com.modespring.core.domain;

import com.modespring.core.domain.bean.MessageBean;

import javax.persistence.Entity;
import java.util.Date;

/**
 * Created by Shawoe on 2015/4/17.
 */
@Entity
public class Message extends MessageBean {

    public Message() {
        this.setSendTime(new Date());
    }

}
