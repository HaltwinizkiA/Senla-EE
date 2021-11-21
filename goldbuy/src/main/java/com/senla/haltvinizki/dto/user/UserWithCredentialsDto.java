package com.senla.haltvinizki.dto.user;

import com.senla.haltvinizki.dto.credentials.CredentialsInfoDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class UserWithCredentialsDto {
    private UserInfoDto user;
    private CredentialsInfoDto credentials;

    public UserInfoDto getUser() {
        return user;
    }

    public void setUser(UserInfoDto user) {
        this.user = user;
    }

    public CredentialsInfoDto getCredentials() {
        return credentials;
    }

    public void setCredentials(CredentialsInfoDto credentials) {
        this.credentials = credentials;
    }
}
