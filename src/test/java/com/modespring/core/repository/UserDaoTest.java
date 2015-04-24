package com.modespring.core.repository;

import static com.modespring.core.common.TestConstant.*;
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
import java.util.List;

/**
 * Created by Shawoe on 2015/4/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("/application-context.xml")
@TransactionConfiguration(defaultRollback = true)
@Transactional
public class UserDaoTest {

    @Autowired
    private UserDao userTestDao;
    private static Integer userTestId;

    @Before
    @Test
    public void saveUserTest() {
        User user = new User();
        user.setUserName(userTestName);
        user.setUserPassword(userTestPassword);
        user.setUserEmail(userTestEmail);
        user = userTestDao.save(user);
        Assert.assertEquals(userTestName, user.getUserName());
        Assert.assertEquals(userTestPassword, user.getUserPassword());
        Assert.assertEquals(userTestEmail, user.getUserEmail());
        userTestId = user.getUserId();
    }

    @Test
    public void updateUserTest() {
        User user = new User();
        user.setUserId(userTestId);
        user.setUserName(userNewTestName);
        user.setUserPassword(userNewTestPassword);
        user.setUserEmail(userNewTestEmail);
        user = userTestDao.saveAndFlush(user);
        Assert.assertEquals(userTestId, user.getUserId());
        Assert.assertEquals(userNewTestName, user.getUserName());
        Assert.assertEquals(userNewTestPassword, user.getUserPassword());
        Assert.assertEquals(userNewTestEmail, user.getUserEmail());
    }

    @Test
    public void findUserByUserNameTest() {
        User user = userTestDao.findUserByUserName(userTestName);
        Assert.assertEquals(userTestName, user.getUserName());
        Assert.assertEquals(userTestPassword, user.getUserPassword());
        Assert.assertEquals(userTestEmail, user.getUserEmail());
    }

    @Test
    public void findUserByUserEmailTest() {
        User user = userTestDao.findUserByUserEmail(userTestEmail);
        Assert.assertEquals(userTestName, user.getUserName());
        Assert.assertEquals(userTestPassword, user.getUserPassword());
        Assert.assertEquals(userTestEmail, user.getUserEmail());
    }

    @Test
    public void findAllUsersTest() {
        List<User> userList= userTestDao.findAll();
        Assert.assertNotNull(userList);
    }

    @Test
    public void deleteUserTest() {
        userTestDao.delete(userTestId);
    }

}
