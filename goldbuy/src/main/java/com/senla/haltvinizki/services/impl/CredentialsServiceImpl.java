package com.senla.haltvinizki.services.impl;


import com.senla.haltvinizki.dao.CredentialsDao;
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
    public Credentials delete(Credentials credentials) {
        return credentialsDao.delete(credentials);
    }

    @Override
    public Credentials create(Credentials credentials) {
        return credentialsDao.create(credentials);
    }

    @Override
    public Credentials update(Credentials credentials) {
        return credentialsDao.update(credentials);
    }

    @Override
    public Credentials getById(int id) {
        return credentialsDao.getById(id);
    }

    @Override
    public Credentials getCredentialsWithUser(int id) {
        return credentialsDao.getCredentialsWithUser(id);
    }
}
