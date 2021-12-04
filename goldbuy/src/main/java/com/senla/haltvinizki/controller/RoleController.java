package com.senla.haltvinizki.controller;


import com.senla.haltvinizki.dto.role.RoleInfoDto;
import com.senla.haltvinizki.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@RestController
@RequiredArgsConstructor
@RequestMapping("/roles")
public class RoleController {

    private final RoleService roleService;

    @PostMapping
//    @Secured("ROLE_ADMIN")
    public RoleInfoDto createRole(@RequestBody RoleInfoDto roleInfoDto) {
        return roleService.create(roleInfoDto);

    }

    @GetMapping(value = "/{id}")
//    @Secured({"ROLE_ADMIN", "User"})
    public RoleInfoDto getById(@PathVariable Long id) {
        return roleService.getById(id);
    }

    @PutMapping
//    @Secured("ROLE_ADMIN")
    public RoleInfoDto updateRole(@RequestBody RoleInfoDto roleInfoDto) {
        return roleService.update(roleInfoDto);
    }

    @DeleteMapping(value = "/{id}")
//    @Secured("ROLE_ADMIN")
    public RoleInfoDto deleteRole(@PathVariable Long id) {
        return roleService.delete(id);
    }
}
