package com.senla.haltvinizki.dto.role;


import com.senla.haltvinizki.dto.user.UserInfoDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoleWitUsersDto {
    private RoleInfoDto role;
    private List<UserInfoDto> users;

    public List<UserInfoDto> getUsers() {
        return users;
    }

    public void setUsers(List<UserInfoDto> users) {
        this.users = users;
    }

    public RoleInfoDto getRole() {
        return role;
    }

    public void setRole(RoleInfoDto role) {
        this.role = role;
    }
}
