package com.gh.controller;

import com.gh.model.User;
import com.gh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("find/{id}")
    @ResponseBody
    public User findById(@PathVariable Integer id){
        return userService.findById(id);
    }
}
