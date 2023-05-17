package com.crud.fullstack.services;

import com.crud.fullstack.config.JwtService;
import com.crud.fullstack.controllers.AuthRes;
import com.crud.fullstack.controllers.RegisterRequest;
import com.crud.fullstack.models.UserModel;
import com.crud.fullstack.repo.UserRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterService {
  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  private final JwtService jwtService;
    public AuthRes register(RegisterRequest request){
      UserModel user = UserModel.builder()
        .username(request.getLogin())
        .email(request.getEmail())
        .password(passwordEncoder.encode(request.getPassword()))
        .build();


      userRepository.save(user);

      String token = jwtService.generateToken(user);

      return AuthRes.builder()
        .token(token)
        .build();
    }
}
