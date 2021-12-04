package com.senla.haltvinizki.controller;

import com.senla.haltvinizki.dto.user.UserInfoDto;
import com.senla.haltvinizki.dto.user.UserWithCredentialsDto;
import com.senla.haltvinizki.dto.user.UserWithRolesDto;
import com.senla.haltvinizki.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;


@Component
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public UserInfoDto createUser(@RequestBody UserInfoDto userInfoDto) {
        return userService.create(userInfoDto);

    }

    @GetMapping(value = "/{id}")
    public UserInfoDto getById(@PathVariable Long id) {
        return userService.getById(id);
    }

    @GetMapping(value = "/credentials/{id}")
    public UserWithCredentialsDto getWithCredById(@PathVariable Long id) {
        return userService.getUserWithCredentials(id);
    }

    @PutMapping
    public UserInfoDto updateUser(@RequestBody UserInfoDto userInfoDto) {
        return userService.update(userInfoDto);

    }

    @GetMapping(value = "/rol/{id}")
    public UserWithRolesDto getByNameWithRoles() {
        return userService.getByNameWithRoles("test");
    }

    @DeleteMapping(value = "/{id}")
//    @Secured("ROLE_ADMIN")
    public UserInfoDto deleteUser(@PathVariable Long id) {
        return userService.delete(id);
    }


}
