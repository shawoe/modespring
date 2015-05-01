package com.modespring.core.webapp;

import com.modespring.core.common.WebsiteContext;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Shawoe on 2015/5/1.
 */
public abstract class BaseController {

    @Autowired
    protected WebsiteContext Context;

}
