package com.senla.haltvinizki.security.filter;

import liquibase.pro.packaged.S;
import org.example.security.JwtProvider;
import org.example.security.UserDetailServiceImpl;
import org.springframework.http.HttpHeaders;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class JwtAuthenticationFilter extends OncePerRequestFilter {
    public static final String BEARER="Bearer";
    private final JwtProvider jwtProvider;
    private final UserDetailServiceImpl userDetailService;

    public JwtAuthenticationFilter(JwtProvider jwtProvider, UserDetailServiceImpl userDetailService) {
        this.jwtProvider = jwtProvider;
        this.userDetailService = userDetailService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        final String authorization=httpServletRequest.getHeader(HttpHeaders.AUTHORIZATION);
        if (authorization!=null&&authorization.startsWith(BEARER));
        final String token=authorization.substring(BEARER.length());
        final String username=jwtProvider.get
    }
}
