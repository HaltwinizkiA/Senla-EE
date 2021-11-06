package com.senla.haltvinizki.controllers;


import com.senla.haltvinizki.controllers.mapper.GsonMapper;
import com.senla.haltvinizki.entity.role.Role;
import com.senla.haltvinizki.services.ProductService;
import com.senla.haltvinizki.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;

public class RoleController {
    @Autowired
    RoleService roleService;
    @Autowired
    GsonMapper gsonMapper;

    public RoleController(RoleService roleService, GsonMapper gsonMapper) {
        this.roleService = roleService;
        this.gsonMapper = gsonMapper;
    }

    public String createRole(String jsonProduct) {
        Role role = roleService.create((Role) gsonMapper.createObj(jsonProduct, Role.class));
        return gsonMapper.createJson(role);
    }

    public String readRole() {
        return gsonMapper.createJson(roleService.read());
    }

    public String updateRole(String jsonProduct) {
        Role role = roleService.update((Role) gsonMapper.createObj(jsonProduct, Role.class));
        return gsonMapper.createJson(role);
    }

    public String deleteRole(String jsonProduct) {
        Role role = roleService.delete((Role) gsonMapper.createObj(jsonProduct, Role.class));
        return gsonMapper.createJson(role);
    }
}
