package com.senla.haltvinizki.dao;

import com.senla.haltvinizki.entity.Role;

import java.util.List;

public interface RoleDao extends GenericDao<Role, Long> {

    Role getRoleWithUsers(Long id);

    List<Role> getUser();

    Role getModerator();
}
