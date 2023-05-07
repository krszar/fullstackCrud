package com.crud.fullstack.services;

import com.crud.fullstack.models.UserModel;
import com.crud.fullstack.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;

@Service
public class LoginService {
    @Autowired
    private UserRepository userRepository;

    public UserModel login(String email, String password) throws AuthenticationException {
        UserModel user = userRepository.findByEmail(email);

        if (user != null || !user.getPassword().equals(password)){
            throw new AuthenticationException("zły email");
        }
        return user;

    }


}
