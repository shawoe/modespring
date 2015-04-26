package com.modespring.core.service;

import static com.modespring.core.common.ExceptionMessage.*;
import static com.modespring.core.common.TestDefaultValue.*;
import com.modespring.core.domain.User;
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

    @Before
    @Test
    public void registerUserTest() throws Exception {
        User user = new User();
        user.setUserName(userTestName);
        user.setUserPassword(userTestPassword);
        user.setUserEmail(userTestEmail);
        try {
            user = userTestService.register(user);
        } catch (Exception e) {
            Assert.assertEquals(USER_EXISTENCE_EXCEPTION, e.getMessage());
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
