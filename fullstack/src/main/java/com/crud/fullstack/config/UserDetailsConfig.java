package com.crud.fullstack.config;


import com.crud.fullstack.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Configuration
@RequiredArgsConstructor
public class UserDetailsConfig {

  private final UserRepository userRepository;

  @Bean
  public UserDetailsService userDetailsService(){

    return username -> userRepository.findByEmail(username);
  }

  @Bean public AuthenticationProvider authenticationProvider(){

  }
}
