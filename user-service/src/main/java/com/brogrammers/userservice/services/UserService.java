package com.brogrammers.userservice.services;

import com.brogrammers.userservice.entities.User;
import com.brogrammers.userservice.DTOs.UserRequest;
import com.brogrammers.userservice.DTOs.UserResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
     UserResponse getUser(Long id);
     Page<UserResponse> getAllUsers(Pageable pageable);
     UserResponse addUser(UserRequest userRequest);
     UserResponse addAdmin(UserRequest userRequest);
     void deleteUser(Long id);
     UserResponse updateUser(UserRequest user);
}
