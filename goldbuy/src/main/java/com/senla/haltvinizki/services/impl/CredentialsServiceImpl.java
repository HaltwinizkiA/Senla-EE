package com.senla.haltvinizki.services.impl;


import com.senla.haltvinizki.dao.CredentialsDao;
import com.senla.haltvinizki.dto.credentials.CredentialsInfoDto;
import com.senla.haltvinizki.dto.credentials.CredentialsWithUserDto;
import com.senla.haltvinizki.entity.credentials.Credentials;
import com.senla.haltvinizki.services.CredentialsService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
@RequiredArgsConstructor
public class CredentialsServiceImpl implements CredentialsService {

    @Autowired
    private final CredentialsDao credentialsDao;
    @Autowired
    private ModelMapper mapper;

    @Override
    public CredentialsInfoDto delete(CredentialsInfoDto credentialsDto) {
        Credentials credentials = mapper.map(credentialsDto, Credentials.class);
        return mapper.map(credentialsDao.delete(credentials), CredentialsInfoDto.class);
    }

    @Override
    public CredentialsInfoDto create(CredentialsInfoDto credentialsDto) {
        Credentials credentials = mapper.map(credentialsDto, Credentials.class);
        return mapper.map(credentialsDao.create(credentials), CredentialsInfoDto.class);
    }

    @Override
    public CredentialsInfoDto update(CredentialsInfoDto credentialsDto) {
        Credentials credentials = mapper.map(credentialsDto, Credentials.class);
        return mapper.map(credentialsDao.update(credentials), CredentialsInfoDto.class);
    }

    @Override
    public CredentialsInfoDto getById(int id) {
        Credentials credentials = credentialsDao.getById(id);
        return mapper.map(credentials, CredentialsInfoDto.class);
    }

    @Override
    public CredentialsWithUserDto getCredentialsWithUser(int id) {
        Credentials credentials = credentialsDao.getCredentialsWithUser(id);
        CredentialsWithUserDto credentialsWithUserDto=mapper.map(credentials,CredentialsWithUserDto.class);
        return credentialsWithUserDto;
    }
}
