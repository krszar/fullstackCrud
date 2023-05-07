package com.crud.fullstack.controllers;

import com.crud.fullstack.services.LoginService;
import com.crud.fullstack.services.RegisterService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class LoginController {
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/login")
    @Autowired
    public String login() {
        return "fdsfsddfs";
    }
//    private LoginService loginService;

}
