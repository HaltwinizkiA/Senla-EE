package com.senla.haltvinizki.security.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.senla.haltvinizki.security.AcExcp;
import com.senla.haltvinizki.security.JwtProvider;
import com.senla.haltvinizki.security.filter.JwtAuthenticationFilter;
import com.senla.haltvinizki.security.filter.LoginFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.LogoutFilter;

@EnableGlobalMethodSecurity(
        prePostEnabled = true,
        securedEnabled = true,
        jsr250Enabled = true)
@EnableWebSecurity
@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailService;
    @Autowired
    private JwtProvider jwtProvider;


    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService).passwordEncoder(bCryptPasswordEncoder());
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/**")
                .httpBasic().disable()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilterBefore(new JwtAuthenticationFilter(jwtProvider, userDetailService), LogoutFilter.class)
                .addFilter(new LoginFilter(jwtProvider, objectMapper(), authenticationManager()))
                .exceptionHandling()
                .accessDeniedHandler(
                        (request, response, accessDeniedException) -> {
                            response.getOutputStream().println();

                        })
                .authenticationEntryPoint(
                        (request, response, authException) -> {
                            response.getOutputStream().println();
                        }
                )
        ;
    }

}


