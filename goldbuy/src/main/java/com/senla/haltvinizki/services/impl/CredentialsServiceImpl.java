package com.senla.haltvinizki.services.impl;


import com.senla.haltvinizki.dao.CredentialsDao;
import com.senla.haltvinizki.dto.credentials.CredentialsInfoDto;
import com.senla.haltvinizki.dto.credentials.CredentialsWithUserDto;
import com.senla.haltvinizki.entity.Credentials;
import com.senla.haltvinizki.services.CredentialsService;
import com.senla.haltvinizki.services.converter.CredentialsConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
@RequiredArgsConstructor
public class CredentialsServiceImpl implements CredentialsService {

    private final CredentialsDao credentialsDao;
    private final CredentialsConverter credentialsConverter;

    @Override
    public CredentialsInfoDto delete(Long id) {
        return credentialsConverter.convert(credentialsDao.delete(id));
    }

    @Override
    public CredentialsInfoDto create(CredentialsInfoDto credentialsDto) {
        Credentials credentials = credentialsConverter.convert(credentialsDto);
        return credentialsConverter.convert(credentialsDao.create(credentials));
    }

    @Override
    public CredentialsInfoDto update(CredentialsInfoDto credentialsDto) {
        Credentials credentials=credentialsConverter.convert(credentialsDto);
        return credentialsConverter.convert(credentialsDao.update(credentials));
    }

    @Override
    public CredentialsInfoDto getById(Long id) {
        return credentialsConverter.convert(credentialsDao.getById(id));
    }

    @Override
    public CredentialsWithUserDto getCredentialsWithUser(Long id) {
        Credentials credentials=credentialsDao.getCredentialsWithUser(id);
        CredentialsWithUserDto credentialsWithUserDto=credentialsConverter.covert(credentials);
        credentialsWithUserDto.setCredentialsInfoDto(credentialsConverter.convert(credentials));
        return credentialsWithUserDto;
    }
}
