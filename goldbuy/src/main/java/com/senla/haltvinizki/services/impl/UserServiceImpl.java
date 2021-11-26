package com.senla.haltvinizki.services.impl;


import com.senla.haltvinizki.dao.UserDao;
import com.senla.haltvinizki.dto.user.UserInfoDto;
import com.senla.haltvinizki.dto.user.UserWithCredentialsDto;
import com.senla.haltvinizki.dto.user.UserWithProductsDto;
import com.senla.haltvinizki.dto.user.UserWithRolesDto;
import com.senla.haltvinizki.entity.User;
import com.senla.haltvinizki.services.UserService;
import com.senla.haltvinizki.services.converter.UserConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;


@Component
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserDao userDao;
    private final UserConverter userConverter;

    @Override
    @Transactional
    public UserInfoDto delete(Long id) {
        return userConverter.convert(userDao.delete(id));
    }

    @Override
    public UserInfoDto create(UserInfoDto userDto) {
        User user = userConverter.convert(userDto);
        return userConverter.convert(userDao.create(user));
    }

    @Override
    public UserInfoDto update(UserInfoDto userDto) {
        User user = userConverter.convert(userDto);
        return userConverter.convert(userDao.update(user));
    }

    @Override

    public UserInfoDto getById(Long id) {
        return userConverter.convert(userDao.getById(id));
    }

    @Override
    public UserWithCredentialsDto getUserWithCredentials(Long id) {
        User user = userDao.getUserWithCredentials(id);
        UserWithCredentialsDto userWithCredentialsDto = userConverter.convertWithCredentials(user);
        userWithCredentialsDto.setUser(userConverter.convert(user));
        return userWithCredentialsDto;
    }

    @Override
    public UserWithProductsDto getUserWithProducts(Long id) {
        User user = userDao.getUserWithCredentials(id);
        UserWithProductsDto userWithProductsDto = userConverter.convertWithProduct(user);
        userWithProductsDto.setUser(userConverter.convert(user));
        return userWithProductsDto;
    }

    @Override
    public UserWithRolesDto getUserWithRole(Long id) {
        User user = userDao.getUserWithCredentials(id);
        UserWithRolesDto userWithRolesDto = userConverter.convertWithRoles(user);
        userWithRolesDto.setUser(userConverter.convert(user));
        return userWithRolesDto;
    }

    @Override
    public UserInfoDto getUserWithLogin(String login) {
        return userConverter.convert(userDao.getUserWithLogin(login));
    }

    @Override
    public List<UserInfoDto> getAllAdmin() {
        return userConverter.convert(userDao.getAllAdmin());
    }
}
