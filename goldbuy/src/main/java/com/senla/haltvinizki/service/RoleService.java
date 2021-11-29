package com.senla.haltvinizki.service;

import com.senla.haltvinizki.dto.role.RoleInfoDto;
import com.senla.haltvinizki.dto.role.RoleWitUsersDto;

public interface RoleService {
    RoleInfoDto delete(Long id);

    RoleInfoDto create(RoleInfoDto roleDto);

    RoleInfoDto update(RoleInfoDto roleDto);

    RoleInfoDto getById(Long id);

    RoleWitUsersDto getRoleWithUsers(Long id);

}
