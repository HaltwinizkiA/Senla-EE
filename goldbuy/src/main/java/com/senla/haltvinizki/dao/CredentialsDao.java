package com.senla.haltvinizki.dao;

import com.senla.haltvinizki.entity.Credentials;

public interface CredentialsDao extends GenericDao<Credentials, Long> {

    Credentials getCredentialsWithUser(Long id);

    Credentials getByUserId(long id);

    Credentials deleteByUserId(long id);
}
