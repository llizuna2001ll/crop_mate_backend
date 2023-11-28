package com.brogrammers.userservice.controllers;

import com.brogrammers.userservice.DTOs.AuthenticationRequest;
import com.brogrammers.userservice.DTOs.AuthenticationResponse;
import com.brogrammers.userservice.DTOs.UserRequest;
import com.brogrammers.userservice.services.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/auth")
public class AuthenticationRestController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody @Valid UserRequest request){

        return new ResponseEntity<>(authenticationService.register(request), HttpStatus.OK);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){
        return new ResponseEntity<>(authenticationService.authenticate(request), HttpStatus.OK);
    }
}
