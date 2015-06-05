package com.bp3.springseed.service;

import com.bp3.springseed.model.User;
import org.fluttercode.datafactory.impl.DataFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dparish
 */
@Service
public class UserServiceImpl implements UserService {
    private DataFactory dataFactory = new DataFactory();

    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    public UserServiceImpl() {
        logger.warn("In constructor");
    }

    @Override
    public boolean checkPassword(String password) {
        return false;
    }

    @Override
    public User getUser(long id) {
        return makeUser(id);
    }

    @Override
    public List<User> getUsers() {
        List<User> users = new ArrayList<User>();
        users.add(makeUser(0l));
        users.add(makeUser(1l));
        users.add(makeUser(2l));
        return users;
    }

    private User makeUser(long id) {
        return new User()
                .setId(id)
                .setFirstName(dataFactory.getFirstName())
                .setLastName(dataFactory.getLastName())
                .setBirthDate(dataFactory.getBirthDate());
    }
}
