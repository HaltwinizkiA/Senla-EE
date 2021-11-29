package com.senla.haltvinizki.controller;

import com.senla.haltvinizki.controller.mapper.JsonMapper;
import com.senla.haltvinizki.dto.user.UserInfoDto;
import com.senla.haltvinizki.service.UserService;
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
    public UserInfoDto createUser(@RequestBody UserInfoDto userInfoDto) {
        return userService.create(userInfoDto);

    }

    @GetMapping(value = "/{id}")
    public UserInfoDto getById(@PathVariable Long id) {
        return userService.getById(id);
    }

    @PutMapping
    public UserInfoDto updateUser(@RequestBody UserInfoDto userInfoDto) {
        return userService.update(userInfoDto);

    }

    @DeleteMapping(value = "/{id}")
    public UserInfoDto deleteUser(@PathVariable Long id) {
        return userService.delete(id);
    }


}
