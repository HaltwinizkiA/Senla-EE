package com.senla.haltvinizki.controllers;

import com.senla.haltvinizki.controllers.mapper.GsonMapper;
import com.senla.haltvinizki.entity.product.Product;
import com.senla.haltvinizki.entity.user.User;
import com.senla.haltvinizki.services.ProductService;
import com.senla.haltvinizki.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    GsonMapper gsonMapper;

    public UserController(UserService userService, GsonMapper gsonMapper) {
        this.userService = userService;
        this.gsonMapper = gsonMapper;
    }

    public String createUser(String jsonUser) {
        User user = userService.create((User) gsonMapper.createObj(jsonUser, User.class));
        return gsonMapper.createJson(user);
    }

    public String readUser() {
        return gsonMapper.createJson(userService.read());
    }

    public String updateUser(String jsonUser) {
        User user = userService.update((User) gsonMapper.createObj(jsonUser, User.class));
        return gsonMapper.createJson(user);
    }

    public String deleteUser(String jsonUser) {
        User user = userService.delete((User) gsonMapper.createObj(jsonUser, User.class));
        return gsonMapper.createJson(user);
    }


}
