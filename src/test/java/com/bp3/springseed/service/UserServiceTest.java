package com.bp3.springseed.service;

import com.bp3.springseed.model.User;
import com.bp3.springseed.repo.UserRepository;
import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

/**
 * @author dparish
 */
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    private UserService userService;

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        userService = new UserServiceImpl(userRepository);
    }

    @Test
    public void testGetUser() {
        when(userService.getUser(3L)).thenReturn(new User().setId(3L));
        User user = userService.getUser(3L);
        assertNotNull(user);
    }

    @Test
    public void testGetYoungUsersNoReturns() throws ParseException {
        setupFindAll();
        Iterable<User> users = userService.getYoungerUsers(simpleDateFormat.parse("01/01/2011"));
        assertThat(users.iterator().hasNext(), equalTo(false));
    }

    @Test
    public void testGetYoungUsersFindOne() throws ParseException {
        setupFindAll();
        Iterable<User> users = userService.getYoungerUsers(simpleDateFormat.parse("01/01/2010"));
        List<User> userList = Lists.newArrayList(users);
        assertThat(userList.size(), equalTo(1));
        assertThat(userList.get(0).getId(), equalTo(2L));
    }

    @Test
    public void testGetYoungUsersFindOneEqualDateNotIncluded() throws ParseException {
        setupFindAll();
        Iterable<User> users = userService.getYoungerUsers(simpleDateFormat.parse("07/25/1969"));
        List<User> userList = Lists.newArrayList(users);
        assertThat(userList.size(), equalTo(1));
        assertThat(userList.get(0).getId(), equalTo(2L));
    }

    @Test
    public void testGetYoungUsersAll() throws ParseException {
        setupFindAll();
        Iterable<User> users = userService.getYoungerUsers(simpleDateFormat.parse("07/25/1950"));
        List<User> userList = Lists.newArrayList(users);
        assertThat(userList.size(), equalTo(2));
    }


    private void setupFindAll() throws ParseException {
        when(userRepository.findAll()).thenReturn(
                Lists.newArrayList(
                        new User()
                                .setId(1L)
                                .setBirthDate(simpleDateFormat.parse("07/25/1969")
                                ),
                        new User()
                                .setId(2L)
                                .setBirthDate(simpleDateFormat.parse("02/01/2010")
                                )
                )
        );
    }
}
