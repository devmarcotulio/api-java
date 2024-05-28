package com.devmarcotulio.api.controllers;

import com.devmarcotulio.api.entities.User;
import com.devmarcotulio.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public User findById(@PathVariable Long id) {
        return userRepository.findById(id).get();
    }

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody User user) {
        User userExists = userRepository.findByEmail(user.getEmail());

        if(userExists != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Email already exists!");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(userRepository.save(user));
    }
}
