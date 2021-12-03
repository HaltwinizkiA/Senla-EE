package com.senla.haltvinizki.security.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.senla.haltvinizki.security.CustomUserDetailsService;
import com.senla.haltvinizki.security.filter.JwtAuthenticationFilter;
import com.senla.haltvinizki.security.filter.LoginFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.LogoutFilter;

@EnableGlobalMethodSecurity(
        securedEnabled = true
)
@EnableWebSecurity
@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailServiceImpl userDetailService;
    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private JwtFilter jwtFilter;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
        @Override
        protected void configure (AuthenticationManagerBuilder auth)throws Exception {
            auth.userDetailsService(userDetailService)
                    .passwordEncoder(bCryptPasswordEncoder());
        }
        @Override
        public void configure (HttpSecurity http) throws Exception {

//        http.httpBasic().disable()
//                .csrf().disable()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                .authorizeRequests()
//                .antMatchers("/admin/*").hasRole("ADMIN")
//                .antMatchers("/user/*").hasRole("USER")
//                .antMatchers("/register", "/auth").permitAll()
//                .and()
//                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

            http.antMatcher("/**")
                    .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                    .and()
                    .httpBasic().disable()
                    .csrf().disable()
                    .addFilter(new LoginFilter(jwtProvider, objectMapper(), authenticationManager()))
                    .addFilterBefore(new JwtAuthenticationFilter(jwtProvider, userDetailService), LogoutFilter.class)
                    .exceptionHandling()
                    .accessDeniedHandler(
                            (request, response, accessDeniedException) -> {
                                response.getOutputStream().println();
                            }).authenticationEntryPoint(
                    (request, response, authException) -> {
                        response.getOutputStream().println();
                    }
            );
        }

    }


