package com.crud.fullstack.controllers;

import com.crud.fullstack.services.LoginService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class LoginController {
  private final LoginService loginService;
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/login")
    @Autowired
    public ResponseEntity<AuthRes> login(@RequestBody AuthenticationRequest request){
      return ResponseEntity.ok(loginService.login(request));
    }

}
