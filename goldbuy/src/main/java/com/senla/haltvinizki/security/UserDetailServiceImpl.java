package com.senla.haltvinizki.security;

import com.senla.haltvinizki.dao.UserDao;
import com.senla.haltvinizki.entity.Role;
import com.senla.haltvinizki.service.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {

    private final UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = Optional.ofNullable(userDao.getByNameWithRoles(username))
                .orElseThrow(() -> new UserNotFoundException(username));
        return new User(
                user.getCredentials().getLogin(),
                user.getCredentials().getPassword(),
                Optional.ofNullable(user.getRoles().get(0))
                        .map(Role::getName)
                        .map(x -> List.of(new SimpleGrantedAuthority("ROLE_" + x)))
                        .orElse(Collections.emptyList()));

    }

}
