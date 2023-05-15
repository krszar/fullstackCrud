package com.crud.fullstack.config;

import com.crud.fullstack.repo.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor

public class SecurityConfig extends OncePerRequestFilter {

    public final JwtService jwtService;

    private final UserDetailsService userDetailsService;

    private final UserRepository userRepository;
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

        if(SecurityContextHolder.getContext().getAuthentication() == null){

         // UserDetails userDetails = this.userDetailsService.loadUserByUsername(userEmail);
           UserDetails userDetails = userRepository.findByEmail(userEmail);

          if (jwtService.tokenValid(jwt, userDetails)){
            UsernamePasswordAuthenticationToken aToken = new UsernamePasswordAuthenticationToken(
              userDetails,
              null,
              userDetails.getAuthorities()
            );
            aToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

            SecurityContextHolder.getContext().setAuthentication(aToken);
          }
        }
        filterChain.doFilter(request, response);
    }
}w
