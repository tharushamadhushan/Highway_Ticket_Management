package com.example.userservice.controller;

import com.example.userservice.reqAndresp.response.JwtAuthResponse;
import com.example.userservice.reqAndresp.secure.SignIn;
import com.example.userservice.reqAndresp.secure.SignUp;
import com.example.userservice.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/auth")
@CrossOrigin("http://localhost:63342")
@RequiredArgsConstructor
public class User {
    private final AuthenticationService authenticationService;

    //signup
   @PostMapping("/signup")
   public ResponseEntity<JwtAuthResponse> signUp(@RequestBody SignUp signUpReq) {
    return ResponseEntity.ok(authenticationService.signUp(signUpReq));
}

    //signIn
    @PostMapping("/signin")
    public ResponseEntity<JwtAuthResponse> signIn(@RequestBody SignIn signInReq) {
        return ResponseEntity.ok(authenticationService.signIn(signInReq));
    }

    //refresh
    @PostMapping("/refresh")
    public ResponseEntity<JwtAuthResponse> refreshToken(@RequestParam ("refreshToken") String refreshToken) {
        return ResponseEntity.ok(authenticationService.refreshToken(refreshToken));
    }
}
