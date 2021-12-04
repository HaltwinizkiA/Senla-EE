package com.senla.haltvinizki.controller;


import com.senla.haltvinizki.dto.credentials.CredentialsInfoDto;
import com.senla.haltvinizki.service.CredentialsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@RestController
@RequiredArgsConstructor
@RequestMapping("/credentials")
public class CredentialsController {

    private final CredentialsService credentialsService;

    @PostMapping
    @Secured({"ROLE_ADMIN","User"})
    public CredentialsInfoDto createCredentials(@RequestBody CredentialsInfoDto credentialsInfoDto) {
        return credentialsService.create(credentialsInfoDto);

    }

    @GetMapping(value = "/{id}")
    @Secured({"ROLE_ADMIN","User"})
    public CredentialsInfoDto getById(@PathVariable Long id) {
        return credentialsService.getById(id);
    }

    @PutMapping
    @Secured({"ROLE_ADMIN","User"})

    public CredentialsInfoDto updateCredentials(@RequestBody CredentialsInfoDto credentialsInfoDto) {
        return credentialsService.update(credentialsInfoDto);

    }
    @DeleteMapping(value = "/{id}")
    @Secured({"ROLE_ADMIN","User"})
    public CredentialsInfoDto deleteCredentials(@PathVariable Long id) {
        return credentialsService.delete(id);

    }

}
