package com.voltlife.backend.config;

import com.voltlife.backend.model.dtos.UserDTO;
import com.voltlife.backend.service.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;


@Configuration
public class TestConfig {
    @Autowired
    private UserService userService;

    @PostConstruct
    public void instanciaDB(){
//        UserDTO user = new UserDTO();
//        user.setEmail("test@gmail.com");
//        user.setPassword("123456");
//        user.setDate("test");
//        user.setName("test");
//        userService.save(user);
    }

}
