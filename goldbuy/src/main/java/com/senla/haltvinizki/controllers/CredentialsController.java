package com.senla.haltvinizki.controllers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.senla.haltvinizki.controllers.mapper.JsonMapper;
import com.senla.haltvinizki.dto.credentials.CredentialsInfoDto;
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
            CredentialsInfoDto credentialsDto = credentialsService.create((CredentialsInfoDto) gsonMapper.createObj(jsonCredentials, CredentialsInfoDto.class));
            return gsonMapper.createJson(credentialsDto);
        } catch (JsonProcessingException e) {
            return "credentials not created";
        }

    }

    public String getById(int id) {
        return gsonMapper.createJson(credentialsService.getById(id));
    }

    public String updateCredentials(String jsonCredentials) {
        try {
            CredentialsInfoDto credentialsDto = credentialsService.update((CredentialsInfoDto) gsonMapper.createObj(jsonCredentials, CredentialsInfoDto.class));
            return gsonMapper.createJson(credentialsDto);
        } catch (JsonProcessingException e) {
            return "credentials not update";
        }
    }

    public String deleteCredentials(String jsonCredentials) {
        try {
            CredentialsInfoDto credentialsDto = credentialsService.delete((CredentialsInfoDto) gsonMapper.createObj(jsonCredentials, CredentialsInfoDto.class));
            return gsonMapper.createJson(credentialsDto);
        } catch (JsonProcessingException e) {
            return "credentials not deleted";
        }
    }

}
