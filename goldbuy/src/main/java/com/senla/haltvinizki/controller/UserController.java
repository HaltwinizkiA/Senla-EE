package com.senla.haltvinizki.controller;

import com.senla.haltvinizki.dto.user.UserInfoDto;
import com.senla.haltvinizki.dto.user.UserRegistrationDto;
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

    @PostMapping(value = "/create")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public UserInfoDto createUser(@RequestBody UserInfoDto userInfoDto) {
        return userService.create(userInfoDto);

    }


    @PostMapping(value = "/registration")
    public UserWithCredentialsDto registration(@RequestBody UserRegistrationDto userRegistrationDto) {

        return userService.registration(userRegistrationDto);
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

    @GetMapping(value = "/{id}/roles")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public UserWithRolesDto getByNameWithRoles() {
        return userService.getByNameWithRoles("test");
    }

    @DeleteMapping(value = "/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public UserInfoDto deleteUser(@PathVariable Long id) {
        return userService.delete(id);
    }

    @DeleteMapping(value = "/myself")
    public UserInfoDto deleteYourUser(@AuthenticationPrincipal UserDetailsWithId userInf) {
        return userService.delete(userInf.getId());
    }

    @GetMapping(value = "/my-info")
    public UserInfoDto getUser(@AuthenticationPrincipal UserDetailsWithId userDetailsWithId) {
        return userService.getById(userDetailsWithId.getId());
    }

}
