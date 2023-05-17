package com.crud.fullstack.services;

import com.crud.fullstack.config.JwtService;
import com.crud.fullstack.controllers.AuthRes;
import com.crud.fullstack.controllers.AuthenticationRequest;
import com.crud.fullstack.controllers.RegisterRequest;
import com.crud.fullstack.models.UserModel;
import com.crud.fullstack.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
  private final UserRepository userRepository;
  private final AuthenticationManager authenticationManager;
  private final JwtService jwtService;

  public AuthRes login(AuthenticationRequest request){
    authenticationManager.authenticate(
      new UsernamePasswordAuthenticationToken(
        request.getEmail(),
        request.getPassword()
      )
    );
    UserModel userModel = userRepository.findByEmail(request.getEmail());

    String token = jwtService.generateToken(userModel);

    return AuthRes.builder()
      .token(token)
      .build();
  }

}
