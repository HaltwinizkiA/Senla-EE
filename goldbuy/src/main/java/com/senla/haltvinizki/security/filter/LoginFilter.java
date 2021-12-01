package com.senla.haltvinizki.security.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.senla.haltvinizki.security.JwtProvider;
import org.springframework.security.authentication.AuthenticationManager;

public class LoginFilter {

    public LoginFilter(JwtProvider jwtProvider, ObjectMapper objectMapper, AuthenticationManager authenticationManager) {
    }
}
