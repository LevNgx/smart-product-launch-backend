package com.launchpad.idea_backend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class LoginRequest {

    @Email(message = "Invalid email format!")
    @NotBlank(message = "email is required")
    private String email;

    @NotBlank(message = "Password is required")
    private String password;

    // getters and setters
    public String getEmail(){
        return this.email;
    }

    public void setEmail(String email) { this.email = email; }



    public String getPassword(){
        return password;
    }

    public void setPassword(String password) { this.password = password; }




}
