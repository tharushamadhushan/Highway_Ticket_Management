package com.example.userservice.service;


import com.example.userservice.reqAndresp.response.JwtAuthResponse;
import com.example.userservice.reqAndresp.secure.SignIn;
import com.example.userservice.reqAndresp.secure.SignUp;

public interface AuthenticationService {
    JwtAuthResponse signIn(SignIn signIn);
    JwtAuthResponse signUp(SignUp signUp);
    JwtAuthResponse refreshToken(String accessToken);

}
