package com.senla.haltvinizki.services;

import com.senla.haltvinizki.dto.credentials.CredentialsInfoDto;
import com.senla.haltvinizki.dto.credentials.CredentialsWithUserDto;

public interface CredentialsService {
    CredentialsInfoDto delete(CredentialsInfoDto credentialsDto);

    CredentialsInfoDto create(CredentialsInfoDto credentialsDto);

    CredentialsInfoDto update(CredentialsInfoDto credentialsDto);

    CredentialsInfoDto getById(int id);

    CredentialsWithUserDto getCredentialsWithUser(int id);

}
