package com.launchpad.idea_backend.controller;

import com.launchpad.idea_backend.dto.LoginRequest;
import com.launchpad.idea_backend.dto.RegisterRequest;
import com.launchpad.idea_backend.model.User;
import com.launchpad.idea_backend.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> register(@Valid @RequestBody RegisterRequest registerRequest){
         User user = new User();
         user.setEmail(registerRequest.getEmail());
         user.setName(registerRequest.getName());
         user.setPassword(registerRequest.getPassword());
         return ResponseEntity.ok(userService.register(user));
    }

    @PostMapping("login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest loginRequest){
        Optional<User> loggedInUser = userService.login(loginRequest.getEmail(), loginRequest.getPassword());
        if(loggedInUser.isPresent()){
            return ResponseEntity.ok(loggedInUser.get());
        }
        else {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }
}
