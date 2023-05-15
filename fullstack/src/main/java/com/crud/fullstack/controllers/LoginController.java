package com.crud.fullstack.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class LoginController {
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/login")
    @Autowired
    public ResponseEntity<AuthRes> login(@RequestBody AuthenticationRequest request){

    }

}
