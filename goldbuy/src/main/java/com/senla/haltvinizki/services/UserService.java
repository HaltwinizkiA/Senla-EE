package com.senla.haltvinizki.services;

import com.senla.haltvinizki.dto.user.UserInfoDto;
import com.senla.haltvinizki.dto.user.UserWithCredentialsDto;
import com.senla.haltvinizki.dto.user.UserWithProductsDto;
import com.senla.haltvinizki.dto.user.UserWithRolesDto;

import java.util.List;

public interface UserService {

    UserInfoDto delete(Long id);

    UserInfoDto create(UserInfoDto userDto);

    UserInfoDto update(UserInfoDto userDto);

    UserInfoDto getById(Long id);

    UserWithCredentialsDto getUserWithCredentials(Long id);

    UserWithProductsDto getUserWithProducts(Long id);

    UserWithRolesDto getUserWithRole(Long id);

    UserInfoDto getUserWithLogin(String login);

    List<UserInfoDto> getAllAdmin();


}
