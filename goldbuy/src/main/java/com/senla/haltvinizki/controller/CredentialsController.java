package com.senla.haltvinizki.controller;


import com.senla.haltvinizki.dto.credentials.CredentialsInfoDto;
import com.senla.haltvinizki.entity.Credentials;
import com.senla.haltvinizki.security.entity.UserDetailsWithId;
import com.senla.haltvinizki.service.CredentialsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@RestController
@RequiredArgsConstructor
@RequestMapping("/credentials")
public class CredentialsController {

    private final CredentialsService credentialsService;

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public CredentialsInfoDto createCredentials(@RequestBody CredentialsInfoDto credentialsInfoDto) {
        return credentialsService.create(credentialsInfoDto);
    }

    @GetMapping(value = "/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")//todo with obj
    public CredentialsInfoDto getById(@PathVariable Long id) {
        return credentialsService.getById(id);
    }

    @GetMapping(value = "/my-credentials")
    public CredentialsInfoDto getByUserId(@AuthenticationPrincipal UserDetailsWithId userDetailsWithId){
       return credentialsService.getByUserId(userDetailsWithId.getId());
    }

    @PutMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")//todo with obj
    public CredentialsInfoDto updateCredentials(@RequestBody CredentialsInfoDto credentialsInfoDto) {
        return credentialsService.update(credentialsInfoDto);

    }

    @DeleteMapping(value = "/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")//todo with obj
    public CredentialsInfoDto deleteCredentials(@PathVariable Long id) {
        return credentialsService.delete(id);

    }

}
