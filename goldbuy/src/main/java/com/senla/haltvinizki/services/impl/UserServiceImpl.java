package com.senla.haltvinizki.services.impl;


import com.senla.haltvinizki.dao.UserDao;
import com.senla.haltvinizki.dto.product.ProductInfoDto;
import com.senla.haltvinizki.dto.user.UserInfoDto;
import com.senla.haltvinizki.dto.user.UserWithCredentialsDto;
import com.senla.haltvinizki.dto.user.UserWithProductsDto;
import com.senla.haltvinizki.dto.user.UserWithRolesDto;
import com.senla.haltvinizki.entity.user.User;
import com.senla.haltvinizki.services.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;


@Component
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    @Autowired
    private final UserDao userDao;
    @Autowired
    private ModelMapper mapper;

    @Override
    public UserInfoDto delete(UserInfoDto userDto) {
        User user = mapper.map(userDto, User.class);
        return mapper.map(userDao.delete(user), UserInfoDto.class);
    }

    @Override
    public UserInfoDto create(UserInfoDto userDto) {
        User user = mapper.map(userDto, User.class);
        return mapper.map(userDao.create(user), UserInfoDto.class);
    }

    @Override
    public UserInfoDto update(UserInfoDto userDto) {
        User user = mapper.map(userDto, User.class);
        return mapper.map(userDao.update(user), UserInfoDto.class);
    }

    @Override

    public UserInfoDto getById(int id) {
        User user = userDao.getById(id);
        return mapper.map(user, UserInfoDto.class);
    }

    @Override
    public UserWithCredentialsDto getUserWithCredentials(int id) {
        User user = userDao.getUserWithCredentials(id);
        return mapper.map(user, UserWithCredentialsDto.class);
    }

    @Override
    public UserWithProductsDto getUserWithProducts(int id) {
        User user = userDao.getUserWithProducts(id);
        return mapper.map(user, UserWithProductsDto.class);
    }

    @Override
    public UserWithRolesDto getUserWithRole(int id) {
        User user = userDao.getUserWithRole(id);
        return mapper.map(user, UserWithRolesDto.class);
    }

    @Override
    public UserInfoDto getUserWithLogin(String login) {
        User user = userDao.getUserWithLogin(login);
        return mapper.map(user, UserInfoDto.class);
    }

    @Override
    public List<UserInfoDto> getAllAdmin() {
        List<User> users = userDao.getAllAdmin();
        List<UserInfoDto> usersInfoDto = users.stream().
                map(user -> mapper.map(user, UserInfoDto.class))
                .collect(Collectors.toList());
        return usersInfoDto;

    }
}
