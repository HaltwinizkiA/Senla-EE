package com.senla.haltvinizki.security.service;

import com.senla.haltvinizki.dao.UserDao;
import com.senla.haltvinizki.service.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username)throws UsernameNotFoundException {
        var us = Optional.ofNullable(userDao.getByLoginWithRolesAndCredentials(username))
                .orElseThrow(() -> new UserNotFoundException(username));
        return new User(
                us.getCredentials().getLogin()
                , us.getCredentials().getPassword()
                , us.getRoles().stream().map(role ->
                new SimpleGrantedAuthority("ROLE_" + role.getName())).collect(Collectors.toList()));


    }

}
