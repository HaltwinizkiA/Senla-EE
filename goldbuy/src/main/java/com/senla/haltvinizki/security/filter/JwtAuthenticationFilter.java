package com.senla.haltvinizki.security.filter;


import com.senla.haltvinizki.security.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.util.Optional.ofNullable;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    public static final String BEARER = "Bearer";
    @Autowired
    private JwtProvider jwtProvider;
    @Autowired
    private UserDetailsService userDetailService;


    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        final String authorization = httpServletRequest.getHeader(HttpHeaders.AUTHORIZATION);
        if (authorization != null && authorization.startsWith(BEARER)) {
            final String token = authorization.substring(BEARER.length());
            final String username = jwtProvider.getUsernameFromToken(token);
            ofNullable(userDetailService.loadUserByUsername(username))
                    .ifPresent(
                            x -> SecurityContextHolder.getContext().setAuthentication(
                                    new UsernamePasswordAuthenticationToken(
                                            username, null, x.getAuthorities()//todo
                                    )
                            )
                    );
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);

    }

}


