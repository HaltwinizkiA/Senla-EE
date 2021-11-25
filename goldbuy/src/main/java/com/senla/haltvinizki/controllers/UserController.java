package com.senla.haltvinizki.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.senla.haltvinizki.controllers.mapper.JsonMapper;
import com.senla.haltvinizki.dto.user.UserInfoDto;
import com.senla.haltvinizki.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;


@Component
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private UserService userService;
    private JsonMapper gsonMapper;

    @PostMapping
    public String createUser(String jsonUser) {
        try {
            UserInfoDto user = userService.create((UserInfoDto) gsonMapper.createObj(jsonUser, UserInfoDto.class));
            return gsonMapper.createJson(user);
        } catch (JsonProcessingException e) {
            return "user not created";

        }

    }

    @GetMapping(value = "/{id}")
    public String getById(int id) {
        return gsonMapper.createJson(userService.getById(id));
    }
    @PutMapping
    public String updateUser(String jsonUser) {
        try {
            UserInfoDto user = userService.update((UserInfoDto) gsonMapper.createObj(jsonUser, UserInfoDto.class));
            return gsonMapper.createJson(user);
        } catch (JsonProcessingException e) {
            return "user not update";

        }

    }

    @DeleteMapping(value = "/{id}")
    public String deleteUser(String jsonUser) {
        try {
            UserInfoDto user = userService.delete((UserInfoDto) gsonMapper.createObj(jsonUser, UserInfoDto.class));
            return gsonMapper.createJson(user);
        } catch (JsonProcessingException e) {
            return "user not deleted";

        }
    }


}
