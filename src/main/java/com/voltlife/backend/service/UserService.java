package com.voltlife.backend.service;

import com.voltlife.backend.model.User;
import com.voltlife.backend.model.dtos.UserDTO;
import com.voltlife.backend.repository.UserRepository;
import com.voltlife.backend.utils.Utils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(UserDTO user) {
        if (!userRepository.existsByEmail(user.getEmail())) {
            User newUser = new User();
            newUser.setEmail(user.getEmail());
            newUser.setPassword(Utils.hashPassword(user.getPassword()));
            newUser.setName(user.getName());
            newUser.setDate(user.getDate());
            newUser.setRole(user.getRole());
            return userRepository.save(newUser);
        }

        throw null;
    }

    public User findByUsername(String username) {
        return userRepository.findByEmail(username).orElseThrow(null);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

}
