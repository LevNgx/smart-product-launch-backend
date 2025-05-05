package com.launchpad.idea_backend.controller;

import com.launchpad.idea_backend.dto.LoginRequest;
import com.launchpad.idea_backend.dto.RegisterRequest;
import com.launchpad.idea_backend.dto.TokenResponse;
import com.launchpad.idea_backend.model.User;
import com.launchpad.idea_backend.service.UserService;
import com.launchpad.idea_backend.utility.JwtUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<User> register(@Valid @RequestBody RegisterRequest registerRequest){
         User user = new User();
         user.setEmail(registerRequest.getEmail());
         user.setName(registerRequest.getName());
         user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
         return ResponseEntity.ok(userService.register(user));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest loginRequest){
        try{

            // Step 1: Authenticate the user using Spring Security
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
            );

            // Step 2: If successful, generate JWT token
            String token = jwtUtil.generateToken(loginRequest.getEmail());

            Map<String, Object> map = new HashMap<>();
            map.put("user", userService.findByEmail(loginRequest.getEmail()).get() );
            map.put("token", new TokenResponse(token).getToken());
            return ResponseEntity.ok(map);
        }
        catch(BadCredentialsException ex){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }


    }
}
