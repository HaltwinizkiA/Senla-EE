package com.senla.haltvinizki.security;

import com.senla.haltvinizki.dao.UserDao;
import com.senla.haltvinizki.service.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //todo
        var user = Optional.ofNullable(userDao.getUserWithCredentials(1L))
                .orElseThrow(() -> new UserNotFoundException(username));
        User user1=new User(
                user.getCredentials().getLogin(),
                user.getCredentials().getPassword(), Collections.singleton((new SimpleGrantedAuthority("ROLE_ADMIN"))));
        return user1;
//            user.getCredentials().getPassword(),
//                Optional.ofNullable(user.getRoles().get(0))
//                        .map(Role::getName)
//                        .map(x -> List.of
//                                (new SimpleGrantedAuthority("ROLE_" + x)))
//                        .orElse(Collections.emptyList()));

    }

}
