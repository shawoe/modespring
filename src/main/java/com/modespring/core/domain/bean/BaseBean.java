package com.modespring.core.domain.bean;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;
/**
 * Created by Shawoe on 2015/4/17.
 */
public abstract class BaseBean implements Serializable{

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
