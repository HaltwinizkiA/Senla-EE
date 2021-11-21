package com.senla.haltvinizki.controllers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.senla.haltvinizki.controllers.mapper.JsonMapper;
import com.senla.haltvinizki.dto.CredentialsDto;
import com.senla.haltvinizki.entity.credentials.Credentials;
import com.senla.haltvinizki.services.CredentialsService;

import org.springframework.stereotype.Component;

@Component
public class CredentialsController {
    private CredentialsService credentialsService;
    private JsonMapper gsonMapper;
    public CredentialsController() {
    }

    public CredentialsController(CredentialsService credentialsService, JsonMapper gsonMapper) {
        this.credentialsService = credentialsService;
        this.gsonMapper = gsonMapper;
    }

    public String createCredentials(String jsonCredentials) {
        try {
            CredentialsDto credentials = credentialsService.create((CredentialsDto) gsonMapper.createObj(jsonCredentials, Credentials.class));
            return gsonMapper.createJson(credentials);
        } catch (JsonProcessingException e) {
            return "credentials not created";
        }

    }

    public String getById(int id) {
        return gsonMapper.createJson(credentialsService.getById(id));
    }

    public String updateCredentials(String jsonCredentials) {
        try {
            CredentialsDto credentials = credentialsService.update((CredentialsDto) gsonMapper.createObj(jsonCredentials, Credentials.class));
            return gsonMapper.createJson(credentials);

        } catch (JsonProcessingException e) {
            return "credentials not update";
        }
    }

    public String deleteCredentials(String jsonCredentials) {
        try {
            CredentialsDto credentials = credentialsService.delete((CredentialsDto) gsonMapper.createObj(jsonCredentials, Credentials.class));
            return gsonMapper.createJson(credentials);

        } catch (JsonProcessingException e) {
            return "credentials not deleted";
        }
    }

}
