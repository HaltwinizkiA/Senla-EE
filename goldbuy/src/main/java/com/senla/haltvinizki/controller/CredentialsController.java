package com.senla.haltvinizki.controller;


import com.senla.haltvinizki.dto.credentials.CredentialsInfoDto;
import com.senla.haltvinizki.service.CredentialsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@RestController
@RequestMapping("/credentials")
@RequiredArgsConstructor
public class CredentialsController {
    private CredentialsService credentialsService;

    @PostMapping
    public CredentialsInfoDto createCredentials(@RequestBody CredentialsInfoDto credentialsInfoDto) {
        return credentialsService.create(credentialsInfoDto);

    }

    @GetMapping(value = "/{id}")
    public CredentialsInfoDto getById(@PathVariable Long id) {
        return credentialsService.getById(id);
    }

    @PutMapping
    public CredentialsInfoDto updateCredentials(@RequestBody CredentialsInfoDto credentialsInfoDto) {
        return credentialsService.update(credentialsInfoDto);

    }

    @DeleteMapping(value = "/{id}")
    public CredentialsInfoDto deleteCredentials(@PathVariable Long id) {
        return credentialsService.delete(id);

    }

}
