package com.bp3.springseed.service;

import com.bp3.springseed.model.User;

import java.util.Date;

/**
 * @author dparish
 */
public interface UserService {

    User getUser(long id);

    /**
     * Retrieve all users younger than the given date.
     * @param date the date to check
     * @return iterable of younger users
     */
    Iterable<User> getYoungerUsers(Date date);

    Iterable<User> getUsers();

    User addUser(User user);
}
