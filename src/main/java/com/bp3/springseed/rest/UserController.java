package com.bp3.springseed.rest;

import com.bp3.springseed.model.User;
import com.bp3.springseed.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author dparish
 */
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/password/check", method = RequestMethod.GET)
    public boolean checkPassword(@RequestParam("password") String password) {
        return userService.checkPassword(password);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable("id") Long id) {
        return userService.getUser(id);
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public List<User> getUsers() {
        return userService.getUsers();
    }

}
