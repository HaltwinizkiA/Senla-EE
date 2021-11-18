package com.senla.haltvinizki.controllers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.senla.haltvinizki.controllers.mapper.JsonMapper;
import com.senla.haltvinizki.entity.role.Role;
import com.senla.haltvinizki.services.RoleService;
import com.senla.haltvinizki.util.Logger;

public class RoleController {

    private final RoleService roleService;
    private final JsonMapper gsonMapper;

    public RoleController(RoleService roleService, JsonMapper gsonMapper) {
        this.roleService = roleService;
        this.gsonMapper = gsonMapper;
    }

    public String createRole(String jsonProduct) {
        Role role = null;
        try {
            role = roleService.create((Role) gsonMapper.createObj(jsonProduct, Role.class));

            return gsonMapper.createJson(role);
        } catch (JsonProcessingException e) {
            Logger.execute(this.getClass(), e);
            return "role not created";

        }

    }

    public String getById(int id) {
        return gsonMapper.createJson(roleService.getById(id));
    }

    public String updateRole(String jsonProduct) {
        try {
            Role role = roleService.update((Role) gsonMapper.createObj(jsonProduct, Role.class));
            return gsonMapper.createJson(role);
        } catch (JsonProcessingException e) {
            Logger.execute(this.getClass(), e);
            return "role not update";

        }
    }

    public String deleteRole(String jsonProduct) {
        try {
            Role role = roleService.delete((Role) gsonMapper.createObj(jsonProduct, Role.class));
            return gsonMapper.createJson(role);
        } catch (JsonProcessingException e) {
            Logger.execute(this.getClass(), e);
            return "role not deleted";

        }
    }
}
