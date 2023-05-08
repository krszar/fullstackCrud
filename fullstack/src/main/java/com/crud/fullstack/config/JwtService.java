package com.crud.fullstack.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

    private static final String KEY = "38782F413F4428472B4B6250655368566D597133743677397A24422645294840";

    public String extractNick(String jwt){
        return extractClaims(jwt).getSubject();
    }


    public String generateToken(Map<String, Object> eClaims, UserDetails userDetails){
      return Jwts
        .builder()
        .setClaims(eClaims)
        .setSubject(userDetails.getUsername())
        .setIssuedAt(new Date(System.currentTimeMillis()))
        .setExpiration(new Date(System.currentTimeMillis() + 1000*60*60*24))
        .signWith(getKey(), SignatureAlgorithm.ES256)
        .compact();
    }

    private boolean tokenExp(String token){
      return extractClaims(token).getExpiration().after(new Date());
    }
    public boolean tokenValid(String token, UserDetails userDetails){
      final String nick = extractNick(token);

      return (nick.equals(userDetails.getUsername()));
    }

    private Key getKey(){
        byte[] keyBytes = Decoders.BASE64.decode(KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    private Claims extractClaims(String jwt){
        return Jwts
                .parserBuilder()
                .setSigningKey(getKey())
                .build()
                .parseClaimsJws(jwt)
                .getBody();
    }

}
