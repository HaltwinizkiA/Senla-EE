package com.senla.haltvinizki.controller;


import com.senla.haltvinizki.controller.mapper.JsonMapper;
import com.senla.haltvinizki.dto.role.RoleInfoDto;
import com.senla.haltvinizki.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@RestController
@RequiredArgsConstructor
@RequestMapping("/roles")

public class RoleController {

    private final RoleService roleService;

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
