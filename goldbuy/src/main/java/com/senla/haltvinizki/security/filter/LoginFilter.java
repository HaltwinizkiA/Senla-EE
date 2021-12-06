package com.senla.haltvinizki.security.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.senla.haltvinizki.dto.credentials.CredentialsInfoDto;
import com.senla.haltvinizki.security.JwtProvider;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class LoginFilter extends UsernamePasswordAuthenticationFilter {

    private JwtProvider jwtProvider;
    private ModelMapper mapper;


    public LoginFilter(JwtProvider jwtProvider, ModelMapper mapper, AuthenticationManager authenticationManager) {
        super(authenticationManager);
        this.mapper = mapper;
        this.jwtProvider = jwtProvider;
        this.mapper = mapper;
    }

    @Override
    protected boolean requiresAuthentication(HttpServletRequest request, HttpServletResponse response) {
        return super.requiresAuthentication(request, response);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        CredentialsInfoDto credentialsInfoDto = null;
        try {
            credentialsInfoDto = mapper.map(request.getInputStream(), CredentialsInfoDto.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return getAuthenticationManager().authenticate(
                new UsernamePasswordAuthenticationToken(
                        credentialsInfoDto.getLogin(),
                        credentialsInfoDto.getPassword()
                )
        );
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) {
        String token = prepareJwt(authResult);
        response.addHeader(HttpHeaders.AUTHORIZATION, token);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {

        response.getOutputStream().println("ERROR \nAUTHENTICATION ERROR \nwrong login or password");


        //handle errors
    }

    private String prepareJwt(Authentication authResult) {
        return jwtProvider.buildToken(authResult.getName());
    }
}
