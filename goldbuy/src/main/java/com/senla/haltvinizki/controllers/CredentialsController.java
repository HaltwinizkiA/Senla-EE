package com.senla.haltvinizki.controllers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.senla.haltvinizki.controllers.mapper.JsonMapper;
import com.senla.haltvinizki.dto.credentials.CredentialsInfoDto;
import com.senla.haltvinizki.services.CredentialsService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@RestController
@RequestMapping("/credentials")
@RequiredArgsConstructor
public class CredentialsController {
    private CredentialsService credentialsService;
    private JsonMapper gsonMapper;

    @PostMapping
    public String createCredentials(@RequestBody String jsonCredentials) {
        try {
            CredentialsInfoDto credentialsDto = credentialsService.create((CredentialsInfoDto) gsonMapper.createObj(jsonCredentials, CredentialsInfoDto.class));
            return gsonMapper.createJson(credentialsDto);
        } catch (JsonProcessingException e) {
            return "credentials not created";
        }

    }

    @GetMapping(value = "/{id}")
    public String getById(@PathVariable int id) {
        return gsonMapper.createJson(credentialsService.getById(id));
    }

    @PutMapping
    public String updateCredentials(@RequestBody String jsonCredentials) {
        try {
            CredentialsInfoDto credentialsDto = credentialsService.update((CredentialsInfoDto) gsonMapper.createObj(jsonCredentials, CredentialsInfoDto.class));
            return gsonMapper.createJson(credentialsDto);
        } catch (JsonProcessingException e) {
            return "credentials not update";
        }
    }

    @DeleteMapping(value = "/{id}")
    public String deleteCredentials(@RequestBody String jsonCredentials) {
        try {
            CredentialsInfoDto credentialsDto = credentialsService.delete((CredentialsInfoDto) gsonMapper.createObj(jsonCredentials, CredentialsInfoDto.class));
            return gsonMapper.createJson(credentialsDto);
        } catch (JsonProcessingException e) {
            return "credentials not deleted";
        }
    }

}
