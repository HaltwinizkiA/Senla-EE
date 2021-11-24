package com.senla.haltvinizki.services.impl;

import com.senla.haltvinizki.dao.impl.RoleDaoImpl;
import com.senla.haltvinizki.dto.role.RoleInfoDto;
import com.senla.haltvinizki.dto.role.RoleWitUsersDto;
import com.senla.haltvinizki.entity.Role;
import com.senla.haltvinizki.services.RoleService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleDaoImpl roleDao;
    @Autowired
    private ModelMapper mapper;

    @Override
    public RoleInfoDto delete(RoleInfoDto roleDto) {
        return mapper.map(roleDao.delete(roleDto.getId()), RoleInfoDto.class);
    }

    @Override
    public RoleInfoDto create(RoleInfoDto roleDto) {
        Role role = mapper.map(roleDto, Role.class);
        Role roles=new Role();
        role.setName("TEST");
        role.setId(1);
        roleDao.create(roles);
        return mapper.map(roleDao.create(roles), RoleInfoDto.class);
    }

    @Override
    public RoleInfoDto update(RoleInfoDto roleDto) {
        Role role = mapper.map(roleDto, Role.class);
        return mapper.map(roleDao.update(role), RoleInfoDto.class);
    }

    @Override
    public RoleInfoDto getById(int id) {
        Role role = roleDao.getById(id);
        return mapper.map(role, RoleInfoDto.class);
    }

    @Override
    public RoleWitUsersDto getRoleWithUsers(int id) {
        Role role = roleDao.getRoleWithUsers(id);
        return mapper.map(role, RoleWitUsersDto.class);
    }
}

