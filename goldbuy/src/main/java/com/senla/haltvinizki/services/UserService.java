package com.senla.haltvinizki.services;

import com.senla.haltvinizki.dto.user.UserInfoDto;
import com.senla.haltvinizki.dto.user.UserWithCredentialsDto;
import com.senla.haltvinizki.dto.user.UserWithProductsDto;
import com.senla.haltvinizki.dto.user.UserWithRolesDto;

import java.util.List;

public interface UserService {

    UserInfoDto delete(UserInfoDto userDto);

    UserInfoDto create(UserInfoDto userDto);

    UserInfoDto update(UserInfoDto userDto);

    UserInfoDto getById(int id);

    UserWithCredentialsDto getUserWithCredentials(int id);

    UserWithProductsDto getUserWithProducts(int id);

    UserWithRolesDto getUserWithRole(int id);

    UserInfoDto getUserWithLogin(String login);

    List<UserInfoDto> getAllAdmin();


}
