package com.senla.haltvinizki.services.converter;

import com.senla.haltvinizki.dto.credentials.CredentialsInfoDto;
import com.senla.haltvinizki.dto.credentials.CredentialsWithUserDto;
import com.senla.haltvinizki.entity.Credentials;
import org.modelmapper.ModelMapper;

public class CredentialsConverter {
    ModelMapper mapper=new ModelMapper();

    public Credentials convert(CredentialsInfoDto credentialsInfoDto) {
        return mapper.map(credentialsInfoDto, Credentials.class);
    }

    public CredentialsInfoDto convert(Credentials credentials) {
        return mapper.map(credentials, CredentialsInfoDto.class);
    }

    public Credentials convert(CredentialsWithUserDto credentialsInfoDto) {
        return mapper.map(credentialsInfoDto, Credentials.class);
    }
    public CredentialsWithUserDto covert(Credentials credentials){
        return mapper.map(credentials,CredentialsWithUserDto.class);
    }
}
