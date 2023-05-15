package com.crud.fullstack.services;

import com.crud.fullstack.controllers.AuthRes;
import com.crud.fullstack.controllers.AuthenticationRequest;
import com.crud.fullstack.controllers.RegisterRequest;
import com.crud.fullstack.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
  private final UserRepository userRepository;

  public AuthRes login(AuthenticationRequest request){
    return null;
  }

}
