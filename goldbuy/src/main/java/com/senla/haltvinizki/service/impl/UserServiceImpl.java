package com.senla.haltvinizki.service.impl;


import com.senla.haltvinizki.dao.UserDao;
import com.senla.haltvinizki.dto.user.UserInfoDto;
import com.senla.haltvinizki.dto.user.UserWithCredentialsDto;
import com.senla.haltvinizki.dto.user.UserWithProductsDto;
import com.senla.haltvinizki.dto.user.UserWithRolesDto;
import com.senla.haltvinizki.entity.User;
import com.senla.haltvinizki.service.UserService;
import com.senla.haltvinizki.service.converter.UserConverter;
import com.senla.haltvinizki.service.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

import static java.util.Optional.ofNullable;


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
        final User user = ofNullable(userDao.getById(id))
                .orElseThrow(() -> new UserNotFoundException(id));
        return userConverter.convert(user);
    }

    @Override
    public UserWithCredentialsDto getUserWithCredentials(Long id) {
        return userConverter.convertWithCredentials(userDao.getUserWithCredentials(id));

    }

    @Override
    public UserWithProductsDto getUserWithProducts(Long id) {
        return userConverter.convertWithProduct(userDao.getUserWithProducts(id));
    }

    @Override
    public UserWithRolesDto getUserWithRole(Long id) {
        return userConverter.convertWithRoles(userDao.getUserWithRole(id));

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
