package com.senla.haltvinizki.dao.impl;

import com.senla.haltvinizki.dao.CredentialsDao;
import com.senla.haltvinizki.entity.credentials.Credentials;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CredentialsDaoImpl implements CredentialsDao {
    List<Credentials> credentialsList;

    public CredentialsDaoImpl() {
        this.credentialsList = new ArrayList<>();
        credentialsList.add(new Credentials("asd123", "oleg", 0));
        credentialsList.add(new Credentials("1234", "admin", 1));
    }

    @Override
    public Credentials delete(Credentials credentials) {
        credentialsList.remove(credentials);
        return credentials;
    }

    @Override
    public Credentials create(Credentials credentials) {
        credentialsList.add(credentials);
        return credentials;
    }

    @Override
    public Credentials update(Credentials credentials) {
        for (Credentials soughtCredentials : read()) {
            if (soughtCredentials.getId() == credentials.getId()) {
                soughtCredentials = credentials;
            }
        }
        return credentials;
    }

    @Override
    public List<Credentials> read() {
        return credentialsList;
    }
}
