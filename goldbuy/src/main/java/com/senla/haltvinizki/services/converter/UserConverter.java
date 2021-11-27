package com.senla.haltvinizki.services.converter;

import com.senla.haltvinizki.dto.user.UserInfoDto;
import com.senla.haltvinizki.dto.user.UserWithCredentialsDto;
import com.senla.haltvinizki.dto.user.UserWithProductsDto;
import com.senla.haltvinizki.dto.user.UserWithRolesDto;
import com.senla.haltvinizki.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserConverter {
    ModelMapper mapper = new ModelMapper();

    public User convert(UserInfoDto userInfoDto) {
        return mapper.map(userInfoDto, User.class);
    }

    public UserInfoDto convert(User user) {
        return mapper.map(user, UserInfoDto.class);
    }

    public User convert(UserWithProductsDto userWithProductsDto) {
        return mapper.map(userWithProductsDto, User.class);
    }

    public UserWithProductsDto convertWithProduct(User user) {
        return mapper.map(user, UserWithProductsDto.class);
    }

    public UserWithRolesDto convertWithRoles(User user) {
        return mapper.map(user, UserWithRolesDto.class);
    }

    public List<UserInfoDto> convert(List<User> users) {
        return users.stream().
                map(user -> mapper.map(user, UserInfoDto.class))
                .collect(Collectors.toList());
    }

    public UserWithCredentialsDto convertWithCredentials(User user) {
        return mapper.map(user, UserWithCredentialsDto.class);
    }


}
