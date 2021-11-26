package com.senla.haltvinizki.services.converter;

import com.senla.haltvinizki.dto.role.RoleInfoDto;
import com.senla.haltvinizki.dto.role.RoleWitUsersDto;
import com.senla.haltvinizki.entity.Role;
import org.modelmapper.ModelMapper;

public class RoleConverter {
    ModelMapper mapper = new ModelMapper();

    public Role convert(RoleInfoDto roleInfoDto) {
        return mapper.map(roleInfoDto, Role.class);
    }

    public RoleInfoDto convert(Role role) {
        return mapper.map(role, RoleInfoDto.class);
    }

    public Role convert(RoleWitUsersDto roleWitUsersDto) {
        return mapper.map(roleWitUsersDto, Role.class);
    }

    public RoleWitUsersDto covertWithUser(Role role) {
        return mapper.map(role, RoleWitUsersDto.class);
    }


}
