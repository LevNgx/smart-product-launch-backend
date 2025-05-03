package com.launchpad.idea_backend.service;

import com.launchpad.idea_backend.model.User;
import com.launchpad.idea_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User register(User user){
        return userRepository.save(user);
    }

    public Optional<User> login(String email, String password){
        Optional<User> user = userRepository.findByEmail(email);
        return user.filter(u -> u.getPassword().equals(password));
    }

    public Optional<User> findById(Long id){
        return userRepository.findById(id);
    }

}
