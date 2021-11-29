package com.senla.haltvinizki.service;

import com.senla.haltvinizki.dto.user.UserInfoDto;
import com.senla.haltvinizki.dto.user.UserWithCredentialsDto;
import com.senla.haltvinizki.dto.user.UserWithProductsDto;
import com.senla.haltvinizki.dto.user.UserWithRolesDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
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
