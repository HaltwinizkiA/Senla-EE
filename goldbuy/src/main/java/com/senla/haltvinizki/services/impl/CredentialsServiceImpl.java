package com.senla.haltvinizki.services.impl;


import com.senla.haltvinizki.dao.CredentialsDao;
import com.senla.haltvinizki.dto.CategoryDto;
import com.senla.haltvinizki.dto.CredentialsDto;
import com.senla.haltvinizki.entity.category.Category;
import com.senla.haltvinizki.entity.credentials.Credentials;
import com.senla.haltvinizki.services.CredentialsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
@RequiredArgsConstructor
public class CredentialsServiceImpl implements CredentialsService {

    @Autowired
    private final CredentialsDao credentialsDao;

    @Override
    public CredentialsDto delete(CredentialsDto credentialsDto) {
        Credentials credentials = Credentials.builder().id(credentialsDto.getId()).build();
        return CredentialsDto.builder().id(credentialsDao.delete(credentials).getId()).build();
    }

    @Override
    public CredentialsDto create(CredentialsDto credentialsDto) {
        Credentials credentials = Credentials.builder().id(credentialsDto.getId()).build();
        return CredentialsDto.builder().id(credentialsDao.create(credentials).getId()).build();
    }

    @Override
    public CredentialsDto update(CredentialsDto credentialsDto) {
        Credentials credentials = Credentials.builder().id(credentialsDto.getId()).build();
        return CredentialsDto.builder().id(credentialsDao.update(credentials).getId()).build();
    }

    @Override
    public CredentialsDto getById(int id) {
        Credentials credentials=credentialsDao.getById(id);
        return CredentialsDto.builder().id(credentials.getId()).build();
    }

    @Override
    public CredentialsDto getCredentialsWithUser(int id) {
        Credentials credentials=credentialsDao.getCredentialsWithUser(id);
        return CredentialsDto.builder().id(credentials.getId()).build();
    }
}
