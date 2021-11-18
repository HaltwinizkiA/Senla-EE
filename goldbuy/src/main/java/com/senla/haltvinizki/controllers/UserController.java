package com.senla.haltvinizki.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.senla.haltvinizki.controllers.mapper.JsonMapper;
import com.senla.haltvinizki.entity.user.User;
import com.senla.haltvinizki.services.UserService;
import com.senla.haltvinizki.util.Logger;
import org.springframework.stereotype.Component;


@Component
public class UserController {

    private  UserService userService;
    private  JsonMapper gsonMapper;

    public UserController(UserService userService, JsonMapper gsonMapper) {
        this.userService = userService;
        this.gsonMapper = gsonMapper;
    }


    public String createUser(String jsonUser) {
        try {
            User user = userService.create((User) gsonMapper.createObj(jsonUser, User.class));
            return gsonMapper.createJson(user);
        } catch (JsonProcessingException e) {
            Logger.execute(this.getClass(), e);
            return "user not created";

        }

    }

    public String getById(int id) {
        return gsonMapper.createJson(userService.getById(id));
    }

    public String updateUser(String jsonUser) {
        try {
            User user = userService.update((User) gsonMapper.createObj(jsonUser, User.class));
            return gsonMapper.createJson(user);
        } catch (JsonProcessingException e) {
            Logger.execute(this.getClass(), e);
            return "user not update";

        }

    }

    public String deleteUser(String jsonUser) {
        try {
            User user = userService.delete((User) gsonMapper.createObj(jsonUser, User.class));
            return gsonMapper.createJson(user);
        } catch (JsonProcessingException e) {
            Logger.execute(this.getClass(), e);
            return "user not deleted";

        }
    }


}
