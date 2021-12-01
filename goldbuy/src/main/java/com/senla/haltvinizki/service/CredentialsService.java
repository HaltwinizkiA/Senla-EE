package com.senla.haltvinizki.service;

import com.senla.haltvinizki.dto.credentials.CredentialsInfoDto;
import com.senla.haltvinizki.dto.credentials.CredentialsWithUserDto;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface CredentialsService {
    CredentialsInfoDto delete(Long id);

    CredentialsInfoDto create(CredentialsInfoDto credentialsDto);

    CredentialsInfoDto update(CredentialsInfoDto credentialsDto);

    CredentialsInfoDto getById(Long id);

    CredentialsWithUserDto getCredentialsWithUser(Long id);

}
