package com.voltlife.backend.service;

import com.voltlife.backend.model.User;
import com.voltlife.backend.model.dtos.request.LoginRequest;
import com.voltlife.backend.service.jwt.JwtService;
import com.voltlife.backend.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private JwtService jwtService;

    @Autowired
    private UserService userService;

    public AuthenticationService(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    public String authenticate(LoginRequest authentication) {
        User user = userService.findByUsername(authentication.getEmail());
        String authPass = Utils.hashPassword(authentication.getPassword());
        if (user.getPassword().equals(authPass)) {
            return jwtService.generateToken(user);
        }
        return null;
    }
}
