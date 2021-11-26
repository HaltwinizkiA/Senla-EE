package com.senla.haltvinizki.controllers;


import com.senla.haltvinizki.controllers.mapper.JsonMapper;
import com.senla.haltvinizki.dto.role.RoleInfoDto;
import com.senla.haltvinizki.services.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;
    private final JsonMapper gsonMapper;

    @PostMapping
    public RoleInfoDto createRole(@RequestBody RoleInfoDto roleInfoDto) {
        return roleService.create(roleInfoDto);

    }

    @GetMapping(value = "/{id}")
    public RoleInfoDto getById(@PathVariable Long id) {
        return roleService.getById(id);
    }

    @PutMapping
    public RoleInfoDto updateRole(@RequestBody RoleInfoDto roleInfoDto) {
        return roleService.update(roleInfoDto);
    }

    @DeleteMapping(value = "/{id}")
    public RoleInfoDto deleteRole(@PathVariable Long id) {
        return roleService.delete(id);
    }
}
