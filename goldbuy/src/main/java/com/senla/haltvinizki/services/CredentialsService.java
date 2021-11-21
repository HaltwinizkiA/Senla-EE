package com.senla.haltvinizki.services;

import com.senla.haltvinizki.dto.CredentialsDto;
import com.senla.haltvinizki.entity.credentials.Credentials;

import java.util.List;

public interface CredentialsService {
    CredentialsDto delete(CredentialsDto credentialsDto);

    CredentialsDto create(CredentialsDto credentialsDto);

    CredentialsDto update(CredentialsDto credentialsDto);

    CredentialsDto getById(int id);

    CredentialsDto getCredentialsWithUser(int id);

}
