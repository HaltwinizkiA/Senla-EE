package com.senla.haltvinizki.controller;

import com.senla.haltvinizki.dto.user.UserInfoDto;
import com.senla.haltvinizki.dto.user.UserWithCredentialsDto;
import com.senla.haltvinizki.dto.user.UserWithRolesDto;
import com.senla.haltvinizki.security.entity.UserDetailsWithId;
import com.senla.haltvinizki.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;


@Component
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public UserInfoDto createUser(@RequestBody UserInfoDto userInfoDto) {
        return userService.create(userInfoDto);

    }

    @GetMapping(value = "/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public UserInfoDto getById(@PathVariable Long id) {
        return userService.getById(id);
    }

    @GetMapping(value = "/credentials/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public UserWithCredentialsDto getWithCredById(@PathVariable Long id) {
        return userService.getUserWithCredentials(id);
    }

    @PutMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public UserInfoDto updateUser(@RequestBody UserInfoDto userInfoDto) {
        return userService.update(userInfoDto);

    }

    @GetMapping(value = "/rol/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public UserWithRolesDto getByNameWithRoles() {
        return userService.getByNameWithRoles("test");
    }

    @DeleteMapping(value = "/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public UserInfoDto deleteUser(@PathVariable Long id) {
        return userService.delete(id);
    }

    @DeleteMapping(value = "/delete-you")
    public UserInfoDto deleteYourUser(@AuthenticationPrincipal UserDetailsWithId userInf) {
        return userService.delete(userInf.getId());
    }


    @GetMapping(value = "/my-info")
    public UserInfoDto getUser(@AuthenticationPrincipal UserDetailsWithId userInf) {
        return userService.getById(userInf.getId());

    }

}
