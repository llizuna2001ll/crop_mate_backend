package com.brogrammers.userservice.controllers;

import com.brogrammers.userservice.DTOs.UserRequest;
import com.brogrammers.userservice.DTOs.UserResponse;
import com.brogrammers.userservice.services.UserService;
import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;


@RestController
@RequestMapping("/api/v1/users")
@Validated
public class UserRestController {

    private final UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    ResponseEntity<Page<UserResponse>> getAllUser(@RequestParam(defaultValue = "0") int page,
                                          @RequestParam(defaultValue = "5") int size){
        Pageable pageable = PageRequest.of(page, size);
        Page<UserResponse> users = userService.getAllUsers(pageable);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<UserResponse> getUser(@PathVariable Long id){
        UserResponse user = userService.getUser(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/addUser")
    ResponseEntity<UserResponse> addUser(@Valid @RequestBody UserRequest userRequest){
        UserResponse user = userService.addUser(userRequest);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PostMapping("/addAdmin")
    ResponseEntity<UserResponse> addAdmin(@Valid @RequestBody UserRequest userRequest){
        UserResponse user = userService.addAdmin(userRequest);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/updateUser")
    ResponseEntity<UserResponse> updateUser(@RequestBody UserRequest user){
        UserResponse userResponse = userService.updateUser(user);
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }

    @GetMapping("/resetPasswordRequest")
    ResponseEntity<String> resetPasswordRequest(@RequestParam String email) throws MessagingException, UnsupportedEncodingException {
        userService.resetPasswordRequest(email);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/resetPasswordVerification")
    ResponseEntity<Boolean> resetPasswordVerification(@RequestParam String email, @RequestParam String code){
        boolean codeState = userService.resetPasswordVerification(code, email);
        return new ResponseEntity<>(codeState, HttpStatus.OK);
    }

}
