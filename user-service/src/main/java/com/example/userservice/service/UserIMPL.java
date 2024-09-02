package com.example.userservice.service;

import com.example.userservice.dto.UserDTO;
import com.example.userservice.repo.UserDAO;
import com.example.userservice.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserIMPL implements UserService {


    private final UserDAO userRepo;
    private final Mapping mapping;
    @Override
    public UserDetailsService userDetailService() {
        return username ->
                userRepo.findByEmail(username)
                        .orElseThrow(()-> new UsernameNotFoundException("USER NOT FOUND"));
    }

    @Override
    public void save(UserDTO user) {
        userRepo.save(mapping.toUserEntity(user));

    }



}
