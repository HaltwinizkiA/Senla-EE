package com.senla.haltvinizki.services;

import com.senla.haltvinizki.dto.role.RoleInfoDto;
import com.senla.haltvinizki.dto.role.RoleWitUsersDto;

public interface RoleService {
    RoleInfoDto delete(RoleInfoDto roleDto);

    RoleInfoDto create(RoleInfoDto roleDto);

    RoleInfoDto update(RoleInfoDto roleDto);

    RoleInfoDto getById(int id);

    RoleWitUsersDto getRoleWithUsers(int id);

}
