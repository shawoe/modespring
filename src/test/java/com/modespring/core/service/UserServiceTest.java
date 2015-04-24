package com.modespring.core.service;

import com.modespring.core.domain.User;
import com.modespring.core.repository.UserDao;
import org.junit.Assert;
import org.junit.Before;
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
 * Created by Shawoe on 2015/4/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("/application-context.xml")
@TransactionConfiguration(defaultRollback = true)
@Transactional
public class UserServiceTest {

    @Autowired
    private UserService userTestService;
    private static Integer userTestId;
    private static final String userTestName = "测试用户";
    private static final String userTestPassword = "123123";
    private static final String userTestEmail = "test@modespring.com";
    private static final String userNewTestName = "新注册用户";
    private static final String userNewTestPassword = "666666";
    private static final String userNewTestEmail = "123@modespring.com";

    @Before
    @Test
    public void registerUserTest() throws Exception {
        User user = new User();
        user.setUserName(userTestName);
        user.setUserPassword(userTestPassword);
        user.setUserEmail(userTestEmail);
        try {
            user = userTestService.registerUser(user);
        } catch (Exception e) {
            Assert.assertNotNull(e);
        }
        Assert.assertEquals(userTestName, user.getUserName());
        Assert.assertEquals(userTestPassword, user.getUserPassword());
        Assert.assertEquals(userTestEmail, user.getUserEmail());
        userTestId = user.getUserId();
    }

    @Test
    public void getUserDetailsByIdTest() {
        User user = userTestService.getUserDetailsById(userTestId);
        Assert.assertEquals(userTestName, user.getUserName());
        Assert.assertEquals(userTestPassword, user.getUserPassword());
        Assert.assertEquals(userTestEmail, user.getUserEmail());
    }

}
