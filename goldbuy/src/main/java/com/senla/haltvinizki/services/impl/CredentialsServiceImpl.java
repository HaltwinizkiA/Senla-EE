package com.senla.haltvinizki.services.impl;


import com.senla.haltvinizki.dao.CredentialsDao;
import com.senla.haltvinizki.entity.credentials.Credentials;
import com.senla.haltvinizki.services.CredentialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CredentialsServiceImpl implements CredentialsService {

    @Autowired
    private CredentialsDao credentialsDao;

    public CredentialsServiceImpl(CredentialsDao credentialsDao) {
        this.credentialsDao = credentialsDao;
    }

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
    public List<Credentials> read() {
        return credentialsDao.read();
    }
}
