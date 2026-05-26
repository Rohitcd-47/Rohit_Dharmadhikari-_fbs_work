package com.myntra.service;

import com.myntra.model.User;

public interface UserService 
{
    boolean register(User user);
    User login(String email, String password, String role);
}