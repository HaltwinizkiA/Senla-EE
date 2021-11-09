package com.senla.haltvinizki.controllers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.senla.haltvinizki.controllers.mapper.JsonMapper;
import com.senla.haltvinizki.entity.category.Category;
import com.senla.haltvinizki.entity.credentials.Credentials;
import com.senla.haltvinizki.services.CredentialsService;
import com.senla.haltvinizki.util.Logger;
import org.springframework.stereotype.Component;

@Component
public class CredentialsController {

    private final CredentialsService credentialsService;
    private final JsonMapper gsonMapper;

    public CredentialsController(CredentialsService credentialsService, JsonMapper gsonMapper) {
        this.credentialsService = credentialsService;
        this.gsonMapper = gsonMapper;
    }

    public String createCredentials(String jsonCredentials) {
        try {
            Credentials credentials = credentialsService.create((Credentials) gsonMapper.createObj(jsonCredentials, Credentials.class));
            return gsonMapper.createJson(credentials);
        } catch (JsonProcessingException e) {
            Logger.execute(this.getClass(), e);
            return "credentials not created";
        }

    }

    public String readCredentials() {
        return gsonMapper.createJson(credentialsService.read());
    }

    public String updateCredentials(String jsonCredentials) {
        try {
            Credentials credentials = credentialsService.update((Credentials) gsonMapper.createObj(jsonCredentials, Credentials.class));
            return gsonMapper.createJson(credentials);

        } catch (JsonProcessingException e) {
            Logger.execute(this.getClass(), e);
            return "credentials not update";
        }
    }

    public String deleteCredentials(String jsonCredentials) {
        try {
            Credentials credentials = credentialsService.delete((Credentials) gsonMapper.createObj(jsonCredentials, Credentials.class));
            return gsonMapper.createJson(credentials);

        } catch (JsonProcessingException e) {
            Logger.execute(this.getClass(), e);
            return "credentials not deleted";
        }
    }

}
