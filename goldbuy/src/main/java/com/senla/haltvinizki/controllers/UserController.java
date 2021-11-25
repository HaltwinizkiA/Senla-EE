package com.senla.haltvinizki.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.senla.haltvinizki.controllers.mapper.JsonMapper;
import com.senla.haltvinizki.dto.user.UserInfoDto;
import com.senla.haltvinizki.services.UserService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;


@Component
@RequestMapping()
public class UserController {

    private  UserService userService;
    private  JsonMapper gsonMapper;

    public UserController(UserService userService, JsonMapper gsonMapper) {
        this.userService = userService;
        this.gsonMapper = gsonMapper;
    }


    public String createUser(String jsonUser) {
        try {
            UserInfoDto user = userService.create((UserInfoDto) gsonMapper.createObj(jsonUser, UserInfoDto.class));
            return gsonMapper.createJson(user);
        } catch (JsonProcessingException e) {
            return "user not created";

        }

    }

    public String getById(int id) {
        return gsonMapper.createJson(userService.getById(id));
    }

    public String updateUser(String jsonUser) {
        try {
            UserInfoDto user = userService.update((UserInfoDto) gsonMapper.createObj(jsonUser, UserInfoDto.class));
            return gsonMapper.createJson(user);
        } catch (JsonProcessingException e) {
            return "user not update";

        }

    }

    public String deleteUser(String jsonUser) {
        try {
            UserInfoDto user = userService.delete((UserInfoDto) gsonMapper.createObj(jsonUser, UserInfoDto.class));
            return gsonMapper.createJson(user);
        } catch (JsonProcessingException e) {
            return "user not deleted";

        }
    }


}
