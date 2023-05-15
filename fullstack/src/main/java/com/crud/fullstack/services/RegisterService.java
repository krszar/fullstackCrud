package com.crud.fullstack.services;

import com.crud.fullstack.controllers.AuthRes;
import com.crud.fullstack.controllers.RegisterRequest;
import com.crud.fullstack.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterService {
  private final UserRepository userRepository;
    public AuthRes register(RegisterRequest request){
      return null;
    }
}
