package com.bp3.springseed.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.Map;

/**
 * The main page that serves up the index page.
 * @author dparish
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String welcome(Map<String, Object> model) {
        model.put("time", new Date());
        return "index";
    }

}
