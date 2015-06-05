package com.bp3.springseed.service;

import com.bp3.springseed.Application;
import com.bp3.springseed.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

/**
 * @author dparish
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class})
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    public void testGetUser() {
        User user = userService.getUser(3l);
        assertNotNull(user);
    }
}
