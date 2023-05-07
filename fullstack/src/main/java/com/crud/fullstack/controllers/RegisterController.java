package com.crud.fullstack.controllers;

import com.crud.fullstack.services.RegisterService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor

public class RegisterController {
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/register")
    public String sayHello() {
        return "Hello!";
    }
    private RegisterService registerService;

}
