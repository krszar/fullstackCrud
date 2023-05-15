package com.crud.fullstack.controllers;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString

public class  RegisterRequest {
    private final String email;
    private final String login;
    private final String password;
}
