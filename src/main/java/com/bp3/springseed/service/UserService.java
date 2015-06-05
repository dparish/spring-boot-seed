package com.bp3.springseed.service;

import com.bp3.springseed.model.User;

import java.util.List;

/**
 * @author dparish
 */
public interface UserService {

    boolean checkPassword(String password);

    User getUser(long id);

    List<User> getUsers();
}
