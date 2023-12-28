package com.brogrammers.userservice.services;

import com.brogrammers.userservice.dtos.UserRequest;
import com.brogrammers.userservice.dtos.UserResponse;
import jakarta.mail.MessagingException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.UnsupportedEncodingException;

public interface UserService {
     UserResponse getUser(Long id);
     Page<UserResponse> getAllUsers(Pageable pageable);
     UserResponse addUser(UserRequest userRequest);
     UserResponse addAdmin(UserRequest userRequest);
     void deleteUser(Long id);
     UserResponse updateUser(UserRequest user);
     void resetPasswordRequest(String email) throws MessagingException, UnsupportedEncodingException;
     boolean resetPasswordVerification(String code, String email);
     void sendVerificationEmail(String email, String username, String code)
             throws MessagingException, UnsupportedEncodingException;
}
