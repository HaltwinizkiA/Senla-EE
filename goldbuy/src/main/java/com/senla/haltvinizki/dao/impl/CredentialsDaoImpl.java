package com.senla.haltvinizki.dao.impl;

import com.senla.haltvinizki.dao.CredentialsDao;
import com.senla.haltvinizki.entity.credentials.Credentials;
import org.springframework.stereotype.Component;

@Component
public class CredentialsDaoImpl extends AbstractDao<Credentials, Integer> implements CredentialsDao {
    public CredentialsDaoImpl() {
        super(Credentials.class);
    }
}
