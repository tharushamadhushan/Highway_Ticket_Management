package com.example.userservice.service;

import com.example.userservice.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {
//    String addUser(UserDTO userDTO);
//
//    LoginResponse loginUser(LoginDTO loginDTO);


    UserDetailsService userDetailService();
    void save(UserDTO user);
}
