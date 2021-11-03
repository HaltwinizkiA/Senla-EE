package com.senla.haltvinizki.controllers.impl;

import com.senla.haltvinizki.controllers.UserController;
import com.senla.haltvinizki.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class UserControllerImpl  implements UserController {
    @Autowired
    UserService userService;

    public UserControllerImpl() {
    }

    @Override
    public void execute() {
        userService.execute();

    }
}
