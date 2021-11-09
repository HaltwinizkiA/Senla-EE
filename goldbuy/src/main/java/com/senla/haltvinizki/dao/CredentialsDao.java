package com.senla.haltvinizki.dao;

import com.senla.haltvinizki.entity.credentials.Credentials;

import java.util.List;

public interface CredentialsDao {
   Credentials delete(Credentials credentialsDao);

   Credentials create(Credentials credentialsDao);

   Credentials update(Credentials credentialsDao);

    List<Credentials> read();
}
