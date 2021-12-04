package com.senla.haltvinizki.security.service;

import com.senla.haltvinizki.dao.UserDao;
import com.senla.haltvinizki.service.exception.UserNotFoundException;
import com.senla.haltvinizki.service.exception.category.CategoryNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;


@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserDao userDao;

    @Override
    @SneakyThrows
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var us = Optional.ofNullable(userDao.getByLoginWithRolesAndCredentials(username))
                 .orElseThrow(()->new UserNotFoundException(username));

        if (us==null){
            throw new UserNotFoundException(username);
        }

        return new User(
                us.getCredentials().getLogin()
                , us.getCredentials().getPassword()
                , us.getRoles().stream().map(role ->
                new SimpleGrantedAuthority("ROLE_" + role.getName())).collect(Collectors.toList()));
    }

}
