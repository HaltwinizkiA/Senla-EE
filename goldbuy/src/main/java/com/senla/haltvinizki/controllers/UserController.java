package com.senla.haltvinizki.controllers;
import com.senla.haltvinizki.entity.user.User;
import com.senla.haltvinizki.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class UserController {
    @Autowired
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void createUser(){
        User user;
    }



}
