package com.senla.haltvinizki.services;

import com.senla.haltvinizki.entity.credentials.Credentials;

import java.util.List;

public interface CredentialsService {
    Credentials delete(Credentials credentialsDao);

    Credentials create(Credentials credentialsDao);

    Credentials update(Credentials credentialsDao);

    Credentials getById(int id);

    Credentials getCredentialsWithUser(int id);

}
