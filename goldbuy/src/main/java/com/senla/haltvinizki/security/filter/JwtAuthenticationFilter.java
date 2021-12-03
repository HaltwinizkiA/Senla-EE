//package com.senla.haltvinizki.security.filter;
//
//
//import com.senla.haltvinizki.security.UserDetailServiceImpl;
//import com.senla.haltvinizki.security.configuration.JwtProvider;
//import org.springframework.http.HttpHeaders;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//import static java.util.Optional.ofNullable;
//
//
//public class JwtAuthenticationFilter extends OncePerRequestFilter {
//    public static final String BEARER="Bearer";
//    private final JwtProvider jwtProvider;
//    private final UserDetailServiceImpl userDetailService;
//
//    public JwtAuthenticationFilter(JwtProvider jwtProvider, UserDetailServiceImpl userDetailService) {
//        this.jwtProvider = jwtProvider;
//        this.userDetailService = userDetailService;
//    }
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
//        final String authorization=httpServletRequest.getHeader(HttpHeaders.AUTHORIZATION);
//        if (authorization!=null&&authorization.startsWith(BEARER)){
//        final String token=authorization.substring(BEARER.length());
//        final String username=jwtProvider.getUsernameFromToken(token);
//        ofNullable(userDetailService.loadUserByUsername(username))
//                .ifPresent(
//                        x-> SecurityContextHolder.getContext().setAuthentication(
//                                new UsernamePasswordAuthenticationToken(
//                                        username,null,x.getAuthorities()
//                                )
//                        )
//                );
//        }
//        filterChain.doFilter(httpServletRequest,httpServletResponse);
//
//    }
//
//}
