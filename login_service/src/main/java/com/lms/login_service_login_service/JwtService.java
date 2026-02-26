package com.lms.login_service_login_service;


import java.security.Key;
import java.util.Date;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import org.springframework.stereotype.Service;

@Service
public class JwtService {

    private static final String SECRET =
        "dlms-secret-key-which-should-be-at-least-32-chars";

    private final Key key =
        Keys.hmacShaKeyFor(SECRET.getBytes());

    public String generateToken(String userId, String role) {

        return Jwts.builder()
            .setSubject(userId)
            .claim("role", role)
            .setIssuedAt(new Date())
            .setExpiration(
                new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24)
            )
            .signWith(key, SignatureAlgorithm.HS256)
            .compact();
    }
    
    public Claims parseClaims(String token) {
        return Jwts.parserBuilder()
            .setSigningKey(key)
            .build()
            .parseClaimsJws(token)
            .getBody();
    }
}