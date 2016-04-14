package com.bp3.springseed.service;

import com.bp3.springseed.model.User;
import com.bp3.springseed.repo.UserRepository;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author dparish
 */
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUser(long id) {
        return userRepository.findOne(id);
    }

    @Override
    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Iterable<User> getYoungerUsers(final Date date) {
        return Iterables.filter(userRepository.findAll(), new Predicate<User>() {
            @Override
            public boolean apply(User input) {
                return input.getBirthDate().after(date);
            }
        });
    }
}
