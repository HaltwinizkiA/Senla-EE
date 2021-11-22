package com.senla.haltvinizki.dto.user;

import com.senla.haltvinizki.dto.role.RoleInfoDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class UserWithRolesDto {
    private UserInfoDto user;
    private List<RoleInfoDto> roles;

    public UserInfoDto getUser() {
        return user;
    }

    public void setUser(UserInfoDto user) {
        this.user = user;
    }

    public List<RoleInfoDto> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleInfoDto> roles) {
        this.roles = roles;
    }

}
