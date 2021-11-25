package com.senla.haltvinizki.controllers;


import com.fasterxml.jackson.core.JsonProcessingException;
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
    public String createRole(String jsonProduct) {
        try {
            RoleInfoDto roleDto = roleService.create((RoleInfoDto) gsonMapper.createObj(jsonProduct, RoleInfoDto.class));

            return gsonMapper.createJson(roleDto);
        } catch (JsonProcessingException e) {
            return "role not created";

        }

    }

    @GetMapping(value = "/{id}")
    public String getById(int id) {
        return gsonMapper.createJson(roleService.getById(id));
    }

    @PutMapping
    public String updateRole(String jsonProduct) {
        try {
            RoleInfoDto role = roleService.update((RoleInfoDto) gsonMapper.createObj(jsonProduct, RoleInfoDto.class));
            return gsonMapper.createJson(role);
        } catch (JsonProcessingException e) {
            return "role not update";

        }
    }
    @DeleteMapping(value = "/{id}")
    public String deleteRole(String jsonProduct) {
        try {
            RoleInfoDto role = roleService.delete((RoleInfoDto) gsonMapper.createObj(jsonProduct, RoleInfoDto.class));
            return gsonMapper.createJson(role);
        } catch (JsonProcessingException e) {
            return "role not deleted";

        }
    }
}
