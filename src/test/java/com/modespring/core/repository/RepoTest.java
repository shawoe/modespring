package com.modespring.core.repository;

import com.modespring.core.common.PropertiesUtil;
import com.modespring.core.domain.Article;
import com.modespring.core.domain.Image;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Shawoe on 2015/4/30.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("/application-context.xml")
@TransactionConfiguration(defaultRollback = false)
@Transactional
public class RepoTest {

    @Test
    public  void test() throws IOException, ConfigurationException {
//        PropertiesUtil.createStringProperty("global","a","a");
//        PropertiesUtil.createStringProperty("global","b","a");
        PropertiesUtil.updateStringProperty("global", "a", "c");
        Assert.assertEquals(PropertiesUtil.getStringProperty("global", "site.title"), "校园玩车助理");
        Assert.assertEquals(PropertiesUtil.getStringProperty("global", "b"),"a");
        Assert.assertEquals(PropertiesUtil.getStringProperty("global", "a"),"c");
    }



//    @Autowired
//    ArticleDao articleDao;
//
//    @Autowired
//    ImageDao imageDao;
//
//    @Test
//    public void upload() {
//        Article article = new Article();
//        article.setName("zz");
//        Image image = new Image("a","b","c","d",1);
//        image.setName("xx");
//        List<Image> imageList = new ArrayList<Image>();
//        imageList.add(image);
//        imageList = imageDao.save(imageList);
//        article.setImageList(imageList);
//        articleDao.save(article);
//
//    }
//
//    @Transactional
//    @Test
//    public void get() {
//        Article article = articleDao.getOne(8);
//        List<Image> imageList = article.getImageList();
//        Image image = imageList.get(0);
//        System.out.println("---------------------------------------------"+article.getId());
//        Set<Image> imageSet = new HashSet<>();
//
//    }

}
