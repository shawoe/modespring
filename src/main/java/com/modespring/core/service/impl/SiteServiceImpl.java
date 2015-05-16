package com.modespring.core.service.impl;

import com.modespring.core.domain.Site;
import com.modespring.core.repository.SiteDao;
import com.modespring.core.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Created by Shawoe on 2015/5/1.
 */
@Service
public class SiteServiceImpl implements SiteService {

    @Autowired
    SiteDao siteDao;

    public Site create(Site site) {
        return null;
    }

    public void delete(Integer id) {
        siteDao.delete(id);
    }

    public Site update(Site site) {
        return siteDao.saveAndFlush(site);
    }
    public void updateALL(List<Site> siteList) {
        siteDao.save(siteList);
    }

    public Site getOne(Integer id){
        return siteDao.findOne(id);
    }

    public Site getByName(String name){
        return null;
    }

    public List<Site> getAll() {
        return siteDao.findAll();
    }

}
