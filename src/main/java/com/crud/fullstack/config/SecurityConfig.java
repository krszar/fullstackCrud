package com.crud.fullstack.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor

public class SecurityConfig extends OncePerRequestFilter {

    public final JwtService jwtService;

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain) throws ServletException, IOException {

        final String authHeader = request.getHeader("auth");
        final String jwt;
        final String userEmail;
        final String userNick;
        if(authHeader == null){
            filterChain.doFilter(request, response);
            return;
        }
        jwt = authHeader.substring(1);
        userEmail = jwtService.extractNick(jwt);
    }
}
