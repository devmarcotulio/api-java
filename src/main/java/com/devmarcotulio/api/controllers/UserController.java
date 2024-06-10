package com.devmarcotulio.api.controllers;

import com.devmarcotulio.api.dtos.ResponseDto;
import com.devmarcotulio.api.entities.User;
import com.devmarcotulio.api.exceptions.UserNotFoundException;
import com.devmarcotulio.api.records.UserRecord;
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
    public ResponseEntity<User> findById(@PathVariable Long id) {

        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found with this ID: " + id));

        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<ResponseDto> insert(@RequestBody UserRecord user) {
        User userExists = userRepository.findByEmail(user.email());

        if(userExists != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto("409", "Email already exists!"));
        }

        User userObj = new User(user.name(), user.email(), user.department());
        userRepository.save(userObj);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
