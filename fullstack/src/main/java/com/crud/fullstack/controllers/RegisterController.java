package com.crud.fullstack.controllers;

import com.crud.fullstack.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor

public class RegisterController {

  private final UserService userService;
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/register")
    public ResponseEntity<AuthRes> register(@RequestBody RegisterRequest request){

      return ResponseEntity.ok()
    }

}
