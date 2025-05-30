package com.launchpad.idea_backend.service;

import com.launchpad.idea_backend.model.User;
import com.launchpad.idea_backend.repository.UserRepository;
import com.launchpad.idea_backend.utility.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user =  userRepository.findByEmail(email);
        if(user.isPresent()){
            return new CustomUserDetails(user.get());
        }
        else {
            throw new UsernameNotFoundException("no user found for the provided email : " + email);
        }
    }
}
