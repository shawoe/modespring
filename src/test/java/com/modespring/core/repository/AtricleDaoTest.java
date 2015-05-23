package com.modespring.core.repository;

import com.modespring.core.domain.Article;
import com.modespring.core.domain.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Shawoe on 2015/4/30.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("/application-context.xml")
@TransactionConfiguration(defaultRollback = false)
@Transactional
public class AtricleDaoTest {

    @Autowired
    ArticleDao articleDao;


    @Test
    public void test() {
//        List<Article> articleList = articleDao.findByColumnId(2);
//        System.out.println("--------------------------------------------"+articleList);

    }
}
