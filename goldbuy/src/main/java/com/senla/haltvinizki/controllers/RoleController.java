package com.senla.haltvinizki.controllers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.senla.haltvinizki.controllers.mapper.JsonMapper;
import com.senla.haltvinizki.dto.role.RoleInfoDto;
import com.senla.haltvinizki.services.RoleService;

public class RoleController {

    private final RoleService roleService;
    private final JsonMapper gsonMapper;

    public RoleController(RoleService roleService, JsonMapper gsonMapper) {
        this.roleService = roleService;
        this.gsonMapper = gsonMapper;
    }

    public String createRole(String jsonProduct) {
        try {
         RoleInfoDto roleDto = roleService.create((RoleInfoDto) gsonMapper.createObj(jsonProduct, RoleInfoDto.class));

            return gsonMapper.createJson(roleDto);
        } catch (JsonProcessingException e) {
            return "role not created";

        }

    }

    public String getById(int id) {
        return gsonMapper.createJson(roleService.getById(id));
    }

    public String updateRole(String jsonProduct) {
        try {
            RoleInfoDto role = roleService.update((RoleInfoDto) gsonMapper.createObj(jsonProduct, RoleInfoDto.class));
            return gsonMapper.createJson(role);
        } catch (JsonProcessingException e) {
            return "role not update";

        }
    }

    public String deleteRole(String jsonProduct) {
        try {
            RoleInfoDto role = roleService.delete((RoleInfoDto) gsonMapper.createObj(jsonProduct, RoleInfoDto.class));
            return gsonMapper.createJson(role);
        } catch (JsonProcessingException e) {
            return "role not deleted";

        }
    }
}
