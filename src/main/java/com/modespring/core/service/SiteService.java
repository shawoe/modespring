package com.modespring.core.service;

import com.modespring.core.domain.pojo.Site;
import org.apache.commons.configuration.ConfigurationException;

/**
 * Created by Shawoe on 2015/5/1.
 */
public interface SiteService {

    public void init(Site site, String username, String password, String email) throws ConfigurationException;
    public void update(Site site) throws ConfigurationException;

}
