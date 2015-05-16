package com.modespring.core.webapp.access;

import com.modespring.core.service.singleton.ContextService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Shawoe on 2015/5/1.
 */
public abstract class BaseController {

    @Autowired
    protected ContextService Context;

}
