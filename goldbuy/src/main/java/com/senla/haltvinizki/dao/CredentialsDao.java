package com.senla.haltvinizki.dao;

import com.senla.haltvinizki.entity.Credentials;

public interface CredentialsDao extends GenericDao<Credentials,Long> {

    Credentials getCredentialsWithUser(Long id);

}
