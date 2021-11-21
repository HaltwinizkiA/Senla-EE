package com.senla.haltvinizki.dto.credentials;

import com.senla.haltvinizki.dto.user.UserInfoDto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class CredentialsWithUserDto {
   private CredentialsInfoDto credentials;
   private UserInfoDto user;

    public CredentialsInfoDto getCredentialsInfoDto() {
        return credentials;
    }

    public void setCredentialsInfoDto(CredentialsInfoDto credentials) {
        this.credentials = credentials;
    }


}
