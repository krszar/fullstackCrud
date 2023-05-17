package com.crud.fullstack.services;

import com.crud.fullstack.config.JwtService;
import com.crud.fullstack.controllers.AuthRes;
import com.crud.fullstack.controllers.AuthenticationRequest;
import com.crud.fullstack.models.UserModel;
import com.crud.fullstack.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;

@Service
@RequiredArgsConstructor
public class LoginService {
  private final AuthenticationManager authenticationManager;
  private final JwtService jwtService;
  private final UserRepository userRepository;


    public AuthRes login(AuthenticationRequest request){
        authenticationManager.authenticate(
          new UsernamePasswordAuthenticationToken(
            request.getEmail(),
            request.getPassword()
          )
        );
        UserModel user = userRepository.findByEmail(request.getEmail());
      String token = jwtService.generateToken(user);

      return AuthRes.builder()
        .token(token)
        .build();


    }


}
