package com.brogrammers.userservice.controllers;

import com.brogrammers.userservice.DTOs.AuthenticationRequest;
import com.brogrammers.userservice.DTOs.AuthenticationResponse;
import com.brogrammers.userservice.DTOs.UserRequest;
import com.brogrammers.userservice.services.AuthenticationService;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.UnsupportedEncodingException;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/auth")
public class AuthenticationRestController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody @Valid UserRequest request, HttpServletRequest httpRequest) throws MessagingException, UnsupportedEncodingException {

        return new ResponseEntity<>(authenticationService.register(request, getSiteURL(httpRequest)), HttpStatus.OK);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){
        return new ResponseEntity<>(authenticationService.authenticate(request), HttpStatus.OK);
    }

    @GetMapping("/verify")
    public ModelAndView verifyUser(@Param("code") String code) {
        ModelAndView modelAndView = new ModelAndView();
        if (authenticationService.verify(code)) {
            modelAndView.setViewName("verify_success");
        } else {
            modelAndView.setViewName("verify_failed");
        }
        return modelAndView;
    }

    private String getSiteURL(HttpServletRequest request) {
        String siteURL = request.getRequestURL().toString();
        return siteURL.replace(request.getServletPath(), "");
    }


}
