package com.senla.haltvinizki.dao.impl;

import com.senla.haltvinizki.dao.CredentialsDao;
import com.senla.haltvinizki.entity.category.Category;
import com.senla.haltvinizki.entity.credentials.Credentials;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CredentialsDaoImpl implements CredentialsDao {
    List<Credentials> credentialsList;

    public CredentialsDaoImpl() {
        this.credentialsList = new ArrayList<>();
        credentialsList.add(new Credentials( 0,"oleg", "asd123"));
        credentialsList.add(new Credentials(1, "admin", "1234"));
    }

    @Override
    public Credentials delete(Credentials credentials) {
        credentialsList.removeIf(soughtCredential -> soughtCredential.getId() == credentials.getId());
        return credentials;
    }

    @Override
    public Credentials create(Credentials credentials) {
        credentialsList.add(credentials);
        return credentials;
    }

    @Override
    public Credentials update(Credentials credentials) {
        for (Credentials soughtCredentials : credentialsList) {
            if (soughtCredentials.getId() == credentials.getId()) {
                credentialsList.remove(soughtCredentials);
                credentialsList.add(credentials);
            }
        }
        return credentials;
    }

    @Override
    public List<Credentials> read() {
        return credentialsList;
    }
}
