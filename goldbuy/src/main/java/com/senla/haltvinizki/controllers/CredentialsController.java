package com.senla.haltvinizki.controllers;


import com.senla.haltvinizki.controllers.mapper.GsonMapper;
import com.senla.haltvinizki.entity.category.Category;
import com.senla.haltvinizki.entity.credentials.Credentials;
import com.senla.haltvinizki.services.CategoryService;
import com.senla.haltvinizki.services.CredentialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CredentialsController {
    @Autowired
    CredentialsService credentialsService;
    @Autowired
    GsonMapper gsonMapper;

    public CredentialsController(CredentialsService credentialsService, GsonMapper gsonMapper) {
        this.credentialsService = credentialsService;
        this.gsonMapper = gsonMapper;
    }

    public String createCredentials(String jsonCredentials) {
        Credentials category = credentialsService.create((Credentials) gsonMapper.createObj(jsonCredentials, Credentials.class));
        return gsonMapper.createJson(category);
    }

    public String readCredentials() {
        return gsonMapper.createJson(credentialsService.read());
    }

    public String updateCredentials(String jsonCredentials) {
        Credentials category = credentialsService.update((Credentials) gsonMapper.createObj(jsonCredentials, Credentials.class));
        return gsonMapper.createJson(category);
    }

    public String deleteCredentials(String jsonCredentials) {
        Credentials category = credentialsService.delete((Credentials) gsonMapper.createObj(jsonCredentials, Credentials.class));
        return gsonMapper.createJson(category);
    }

}
