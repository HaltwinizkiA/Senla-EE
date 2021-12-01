package com.senla.haltvinizki.security;


import io.jsonwebtoken.Jwts;

import java.util.HashMap;
import java.util.Map;

public class JwtProvider {
    private String secret;
    private String expiration;

    public String buildToken(String username){
        final Map<String,Object> claims=new HashMap<>();
        claims.put("typ","acces");
        return Jwts.builder()
                .setClaims(claims)
                .setI
    }
}
